package mypackage.scene.info;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mypackage.context.AppContext;
import mypackage.context.ContextValues;

public class InfoController implements Initializable {
	
	@FXML
	private Label infoLabel;
	@FXML
	private Button okBtn;
	@FXML
	private TextField cheat;

	@Override
	public void initialize(URL url, ResourceBundle res) {
		infoLabel.setText("Insert here the info text");
		infoLabel.setMaxWidth(400);
		infoLabel.setWrapText(true);
	}
	
	@FXML
	public void ok() {
		AppContext.getFromContext(ContextValues.INFO, Stage.class).close();
		AppContext.getFromContext(ContextValues.MENU, Stage.class).show();
	}
	
	@FXML
	public void cheat() {
		String cheatText = cheat.getText();
		if ("secret".equals(cheatText)) {
			System.out.println("Cheat enabled");
			cheat.setText("");
			infoLabel.setText("CHEAT ENABLED!");
			AppContext.addInContext(ContextValues.REWARD1, new Boolean(true));
			AppContext.addInContext(ContextValues.REWARD2, new Boolean(true));
			AppContext.addInContext(ContextValues.REWARD3, new Boolean(true));
		}
	}

}
