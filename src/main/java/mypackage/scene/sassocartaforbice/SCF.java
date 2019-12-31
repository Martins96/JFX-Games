package mypackage.scene.sassocartaforbice;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import mypackage.scene.StagePOJO;
import mypackage.util.constants.FileReaderUtils;
import mypackage.util.constants.ResourcesPath;

public class SCF extends StagePOJO {

	public SCF() {
		super();
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(FileReaderUtils.getURL(ResourcesPath.PATH_SCF_PANE));
			TitledPane scfPane = (TitledPane) loader.load();
			
			this.setScene(new Scene(scfPane));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
