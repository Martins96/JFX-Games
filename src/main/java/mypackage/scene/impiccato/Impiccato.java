package mypackage.scene.impiccato;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import mypackage.scene.StagePOJO;
import mypackage.scene.menu.MenuController;
import mypackage.util.constants.FileReaderUtils;
import mypackage.util.constants.ResourcesPath;

public class Impiccato extends StagePOJO {
	
	private ImpiccatoController controller;

	public Impiccato() {
		super();
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(FileReaderUtils.getURL(ResourcesPath.PATH_IMPICCATO_PANE));
			TitledPane impiccatoPane = (TitledPane) loader.load();
			this.controller = loader.<ImpiccatoController>getController();
			
			this.setScene(new Scene(impiccatoPane));
			
			this.setOnShowing(event -> {
				((MenuController) loader.getController()).onShowChecks();
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ImpiccatoController getController() {
		return this.controller;
	}
	
}
