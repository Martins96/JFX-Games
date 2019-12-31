package mypackage.scene;

import javafx.application.Platform;
import javafx.stage.Stage;

public class StagePOJO extends Stage {
	
	public StagePOJO() {
		this.setOnCloseRequest((e) -> {
			Platform.exit();
			System.exit(0);
		}); 
	}
	
}
