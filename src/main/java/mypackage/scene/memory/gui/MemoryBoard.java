package mypackage.scene.memory.gui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mypackage.context.AppContext;
import mypackage.context.ContextValues;
import mypackage.scene.memory.application.MemoryGame;
import mypackage.scene.memory.controller.MemoryController;

public class MemoryBoard implements Observer {

	private final Card[][] boardCards = new Card[4][4];
	private final Pane pane = new Pane();
	private final MemoryController memoryController;
	private final BorderPane borderPane;

	public MemoryBoard(final BorderPane borderPane, final MemoryController memoryController) {
		this.borderPane = borderPane;
		this.memoryController = memoryController;

		memoryController.addObserver(this);

		addTop();
		addCenter();
	}

	private void addTop() {
		final HBox hBox = new HBox();
		hBox.setPadding(new Insets(5));
		hBox.setSpacing(10);
		hBox.setStyle("-fx-background-color: #336699;");

		final Button button = new Button("Ricomincia");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage memory = AppContext.getFromContext(ContextValues.MEMORY, Stage.class);
				memory.close();
				Stage newMemory = new MemoryGame();
				AppContext.addInContext(ContextValues.MEMORY, newMemory);
				newMemory.show();
			}
		});
		
		Button home = new Button("Menu");
		home.setOnAction((e) -> {
			backToMenu();
		});

		hBox.getChildren().add(home);
		hBox.getChildren().add(button);
		borderPane.setTop(hBox);
	}

	private void addCenter() {
		final List<Integer> memoryIds = getShuffledMemoryIds();
		Integer memoryId = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				final Card card = new Card(memoryIds.get(memoryId), memoryController, this);
				memoryId++;
				card.setTranslateX(j * 200);
				card.setTranslateY(i * 200);
				pane.getChildren().add(card);
				boardCards[j][i] = card;
			}
		}
		borderPane.setCenter(pane);
	}

	private List<Integer> getShuffledMemoryIds() {
		final List<Integer> memoryIds = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8);
		Collections.shuffle(memoryIds);
		return memoryIds;
	}

	protected void disable(final boolean disable) {
		for (final Card[] cards : boardCards) {
			for (final Card card : cards) {
				card.setDisable(disable);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals(MemoryController.CHECK)) {
			if (memoryController.getFirstCard().getValue().equals(memoryController.getSecondCard().getValue())
					&& !memoryController.getFirstCard().equals(memoryController.getSecondCard())) {
				memoryController.getFirstCard().setFound();
				memoryController.getSecondCard().setFound();
				
				if (calcolateWin()) {
					AppContext.addInContext(ContextValues.REWARD3, new Boolean(true));
				}
			} else {
				memoryController.getFirstCard().resetValue();
				memoryController.getSecondCard().resetValue();
			}
		}
	}
	
	private void backToMenu() {
		AppContext.getFromContext(ContextValues.MEMORY, Stage.class).hide();
		AppContext.getFromContext(ContextValues.MENU, Stage.class).show();
	}
	
	private boolean calcolateWin() {
		for (Card[] cards : boardCards) {
			for (Card card : cards) {
				if (card.isActive())
					return false;
			}
		}
		return true;
	}

}
