package mypackage.scene.sassocartaforbice;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import mypackage.context.AppContext;
import mypackage.context.ContextValues;

public class SCFController implements Initializable {
		
	@FXML
	private Label console;
	@FXML
	private Label cpuChoice;
	@FXML
	private Button carta;
	@FXML
	private Button sasso;
	@FXML
	private Button forbici;
	@FXML
	private Button home;
	@FXML
	private Button newGame;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		newGame.setDisable(false);
		console.setText("");
	}
	
	
	@FXML
	public void sassoAction() {
		executeGame('S');
	}
	
	@FXML
	public void cartaAction() {
		executeGame('C');
	}
	
	@FXML
	public void forbiciAction() {
		executeGame('F');
	}
	
	@FXML
	public void home() {
		Stage scf = AppContext.getFromContext(ContextValues.SCF, Stage.class);
		Stage menu = AppContext.getFromContext(ContextValues.MENU, Stage.class);
		scf.hide();
		menu.show();
	}
	
	@FXML
	public void newGame() {
		cpuChoice.setText("");
		console.setText("Fai la tua scelta");
		sasso.setDisable(false);
		carta.setDisable(false);
		forbici.setDisable(false);
		newGame.setDisable(true);
	}
	
	
	private void executeGame(char scelta) {
		// scelta casuale della CPU
		char sceltaCPU = sceltaCPU();
		
		//calcolo vincitore
		short result = isPlayerWinner(scelta, sceltaCPU);
		if (result > 0) {
			console.setText("Hai vinto!");
			AppContext.addInContext(ContextValues.REWARD1, new Boolean(true));
		} else if (result == 0) {
			console.setText("Hai pareggiato, riprova");
		} else {
			console.setText("Hai perso :(");
		}
		
		resetBtn();
	}
	
	private char sceltaCPU() {
		Random rand = new Random();
		char sceltaCPU;
		int randomInt = rand.nextInt(3);
		if (randomInt == 0) {
			sceltaCPU = 'S';
			cpuChoice.setText("Il PC ha scelto Sasso");
		} else if (randomInt == 1) {
			sceltaCPU = 'C';
			cpuChoice.setText("Il PC ha scelto Carta");
		} else {
			cpuChoice.setText("Il PC ha scelto Forbici");
			sceltaCPU = 'F';
		}
		
		
		return sceltaCPU;
	}
	
	private short isPlayerWinner(char playerChoice, char cpuChoice) {
		if (playerChoice == cpuChoice)
			return 0;
		if (playerChoice == 'S') {
			if (cpuChoice == 'C')
				return -1;
			if (cpuChoice == 'F')
				return 1;
		}
		if (playerChoice == 'F') {
			if (cpuChoice == 'S')
				return -1;
			if (cpuChoice == 'C')
				return 1;
		}
		if (playerChoice == 'C') {
			if (cpuChoice == 'F')
				return -1;
			if (cpuChoice == 'S')
				return 1;
		}
		System.out.println("Non dovresti essere qui, la scelta del giocatore --> " + playerChoice);
		return -1;
	}
	
	private void resetBtn() {
		carta.setDisable(true);
		sasso.setDisable(true);
		forbici.setDisable(true);
		newGame.setDisable(false);
	}
	
}
