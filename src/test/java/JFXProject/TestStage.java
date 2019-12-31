package JFXProject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import javafx.application.Application;
import javafx.stage.Stage;
import mypackage.context.AppContext;
import mypackage.context.ContextValues;
import mypackage.scene.blackjack.Blackjack;
import mypackage.scene.info.InfoPane;
import mypackage.scene.memory.application.MemoryGame;
import mypackage.scene.menu.Menu;
import mypackage.scene.menu.MenuController;
import mypackage.scene.sassocartaforbice.SCF;

public class TestStage extends Application {

	@Test
	public void test() {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		testOpen();
		testReward();
	}
	
	/**
	 * Controlli se inizializzando lo Stage e richiamando la funzione show questo
	 * viene mostrato senza errori
	 */
	public void testOpen() {
		{
			Stage menu = new Menu();
			menu.show();
			assertTrue("Apertura Menu", menu.isShowing());
			menu.close();
			assertFalse("Chiusura Menu", menu.isShowing());
			System.out.println("Menu pane passato");
		}
		{
			Stage scf = new SCF();
			scf.show();
			assertTrue("Apertura SCF", scf.isShowing());
			scf.close();
			assertFalse("Chiusura SCF", scf.isShowing());
			System.out.println("SCF pane passato");
		}

		{
			Stage blackjack = new Blackjack();
			blackjack.show();
			assertTrue("Apertura Blackjack", blackjack.isShowing());
			blackjack.close();
			assertFalse("Chiusura Blackjack", blackjack.isShowing());
			System.out.println("Blackjack pane passato");
		}

		{
			Stage memory = new MemoryGame();
			memory.show();
			assertTrue("Apertura MemoryGame", memory.isShowing());
			memory.close();
			assertFalse("Chiusura MemoryGame", memory.isShowing());
			System.out.println("MemoryGame pane passato");
		}

		{
			Stage info = new InfoPane();
			info.show();
			assertTrue("Apertura InfoPane", info.isShowing());
			info.close();
			assertFalse("Chiusura InfoPane", info.isShowing());
			System.out.println("InfoPane pane passato");
		}
	}
	
	/**
	 * Inizialmente le reward devono essere settate a false, i bottoni non devono essere
	 * visibili, quando nel contesto viene inserito il booleano relativo alla reward con
	 * valore <code>true</code> deve essere mostrato il bottone di premio.
	 */
	public void testReward() {
		Stage menu = new Menu();
		MenuController controller = ((Menu) menu).getController();
		menu.show();
		assertFalse("Controllo reward1 inizio", controller.isReward1Unlock());
		assertFalse("Controllo reward2 inizio", controller.isReward2Unlock());
		assertFalse("Controllo reward3 inizio", controller.isReward3Unlock());
		menu.hide();
		
		AppContext.addInContext(ContextValues.REWARD1, new Boolean(true));
		AppContext.addInContext(ContextValues.REWARD2, new Boolean(true));
		AppContext.addInContext(ContextValues.REWARD3, new Boolean(true));
		
		menu.show();
		assertTrue("Controllo reward1 fine", controller.isReward1Unlock());
		assertTrue("Controllo reward2 fine", controller.isReward2Unlock());
		assertTrue("Controllo reward3 fine", controller.isReward3Unlock());
		menu.hide();
		
		System.out.println("Controlli di attivazione reward eseguiti");
	}
}
