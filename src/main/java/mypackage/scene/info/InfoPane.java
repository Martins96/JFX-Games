package mypackage.scene.info;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import mypackage.scene.StagePOJO;
import mypackage.util.constants.FileReaderUtils;
import mypackage.util.constants.ResourcesPath;

public class InfoPane extends StagePOJO {
	
	public InfoPane() {
		super();
		
		try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FileReaderUtils.getURL(ResourcesPath.PATH_INFO_PANE));
		BorderPane infoPane = (BorderPane) loader.load();
		
		this.setScene(new Scene(infoPane));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
