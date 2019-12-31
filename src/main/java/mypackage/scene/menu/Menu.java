package mypackage.scene.menu;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import mypackage.scene.StagePOJO;
import mypackage.util.constants.FileReaderUtils;
import mypackage.util.constants.ResourcesPath;

public class Menu extends StagePOJO {
	
	private MenuController controller;

	public Menu() {
		super();
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(FileReaderUtils.getURL(ResourcesPath.PATH_HOME_PANE));
			TitledPane menuPane = (TitledPane) loader.load();
			this.controller = loader.<MenuController>getController();
			
			this.setScene(new Scene(menuPane));
			
			this.setOnShowing(event -> {
				((MenuController) loader.getController()).onShowChecks();
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MenuController getController() {
		return this.controller;
	}

}
