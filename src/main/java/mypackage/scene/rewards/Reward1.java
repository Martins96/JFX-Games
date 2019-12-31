package mypackage.scene.rewards;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import mypackage.scene.StagePOJO;
import mypackage.util.constants.FileReaderUtils;
import mypackage.util.constants.ResourcesPath;

public class Reward1 extends StagePOJO {

	public Reward1() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FileReaderUtils.getURL(ResourcesPath.PATH_REWARD1_PANE));
			SplitPane rewardPane = (SplitPane) loader.load();
			
			this.setScene(new Scene(rewardPane));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

