package mypackage.scene.memory.application;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import mypackage.scene.StagePOJO;
import mypackage.scene.memory.controller.MemoryController;
import mypackage.scene.memory.gui.MemoryBoard;

public class MemoryGame extends StagePOJO {
	
	public MemoryGame() {
		super();
		start();
	}
	
	
	public void start() {
		try {

			final BorderPane root = new BorderPane();
			final Scene scene = new Scene(root, 801, 838);

			new MemoryBoard(root, new MemoryController());
			
			this.setTitle("Memory");
			this.setScene(scene);
			this.show();
			
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
