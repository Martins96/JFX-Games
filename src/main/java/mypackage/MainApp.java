package mypackage;

import javafx.application.Application;
import javafx.stage.Stage;
import mypackage.context.AppContext;
import mypackage.context.ContextValues;
import mypackage.scene.menu.Menu;

public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage menu = new Menu();
		AppContext.addInContext(ContextValues.MENU, menu);
		menu.show();
	}

}
