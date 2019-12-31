package mypackage.scene.memory.gui;

import mypackage.scene.memory.controller.MemoryController;

import mypackage.scene.memory.gui.MemoryBoard;
import mypackage.util.constants.FileReaderUtils;
import mypackage.util.constants.ResourcesPath;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;

public class Card extends StackPane {
	
	public static final Image empty = new Image(FileReaderUtils.getInputStream(ResourcesPath.PATH_MEMORY_EMPTY_CARD));
	private final Rectangle border;
	private final EventHandler<? super MouseEvent> mouseClickEventHandler;
	private Integer memoryId;
	private boolean active = true;

	public Card(Integer memoryId, MemoryController controller, final MemoryBoard memoryBoard) {
		this.memoryId = memoryId;
		border = new Rectangle(200, 200);
		border.setFill(new ImagePattern(empty));
		border.setStroke(Color.BLACK);
		

		setAlignment(Pos.CENTER);
		getChildren().addAll(border);

		setOnMouseClicked(event -> {
			Image image = new Image(FileReaderUtils.getInputStream(ResourcesPath.PATH_MEMORY_HOME + memoryId + ResourcesPath.MEMORY_CARD_EXT));
			border.setFill(new ImagePattern(image));
			if (!controller.isCheckTime()) {
				controller.setFirstCard(this);
				controller.setCheckTime(true);
			} else {
				if (!controller.getFirstCard().equals(this)) {
					memoryBoard.disable(true);
					// aspetto 0,5 secondi per far visualizzare all'utente
					final Timeline tl = new Timeline(new KeyFrame(Duration.millis(500), e -> {
						controller.setSecondCard(this);
						controller.check();
						controller.setCheckTime(false);

						memoryBoard.disable(false);
					}));
					tl.setCycleCount(1);
					tl.play();
				}
			}
		});

		mouseClickEventHandler = getOnMouseClicked();

	}

	protected void activate() {
		setOnMouseClicked(mouseClickEventHandler);
	}

	private void deactivate() {
		setOnMouseClicked(null);
		active = false;
	}
	
	public boolean isActive() {
		return this.active;
	}

	public String getValue() {
		return memoryId.toString();
	}

	public void resetValue() {
		this.border.setFill(new ImagePattern(empty));;
	}

	public Rectangle getRectangleBorder() {
		return border;
	}

	protected void updateMemoryId(final int newMemoryId) {
		this.memoryId = newMemoryId;
	}

	public void setFound() {
		border.setStroke(Color.LIGHTGREEN);
		border.setStrokeType(StrokeType.INSIDE);
		border.setStrokeWidth(5);
		deactivate();
	}

}
