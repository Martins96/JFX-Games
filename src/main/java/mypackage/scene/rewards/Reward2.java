package mypackage.scene.rewards;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import mypackage.scene.StagePOJO;
import mypackage.util.constants.FileReaderUtils;
import mypackage.util.constants.ResourcesPath;

public class Reward2 extends StagePOJO {

	public Reward2() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FileReaderUtils.getURL(ResourcesPath.PATH_REWARD2_PANE));
			SplitPane rewardPane = (SplitPane) loader.load();
			
			this.setScene(new Scene(rewardPane));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

