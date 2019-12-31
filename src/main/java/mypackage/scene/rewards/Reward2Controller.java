package mypackage.scene.rewards;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mypackage.context.AppContext;
import mypackage.context.ContextValues;

public class Reward2Controller {
		
	@FXML
	private Button closeBtn;
	
	
	@FXML
	public void closeRewardPane() {
		AppContext.getFromContext(ContextValues.REWARD2PANE, Stage.class).close();
		AppContext.getFromContext(ContextValues.MENU, Stage.class).show();
	}
	
	
}
