package JFXProject;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import mypackage.scene.blackjack.Card;
import mypackage.scene.blackjack.Rank;
import mypackage.scene.blackjack.Suit;
import mypackage.util.constants.FileReaderUtils;
import mypackage.util.constants.ResourcesPath;

public class TestResources {

	
	/**
	 * Controllo delle risorse se tutte sono presenti (Pane section)
	 */
	@Test
	public void testPane() {
		System.out.println("Running test");
		File menuPane = FileReaderUtils.getFile(ResourcesPath.PATH_HOME_PANE);
		assertTrue("Controllo esistenza menu pane ", menuPane.exists());
		System.out.println("Menu pane exist");

		File infoPane = FileReaderUtils.getFile(ResourcesPath.PATH_INFO_PANE);
		assertTrue("Controllo esistenza info pane ", infoPane.exists());
		System.out.println("Info pane exist");

		File scfPane = FileReaderUtils.getFile(ResourcesPath.PATH_SCF_PANE);
		assertTrue("Controllo esistenza scf pane ", scfPane.exists());
		System.out.println("SCF pane exist");
	}

	/**
	 * Controllo delle risorse se tutte sono presenti (Blackjack section)
	 */
	@Test
	public void testBlackjackResources() {
		File table = FileReaderUtils.getFile(ResourcesPath.PATH_BALCKJACK_TABLE);
		assertTrue("Controllo esistenza tavolo blackjack", table.exists());
		System.out.println("Tavolo da blackjack esiste");
		
		for (Suit s : Suit.VALUES) {
			for (Rank r : Rank.VALUES) {
				File carta = Card.getFile(s, r);
				assertTrue("Controllo carta s=" + s.getName() + " r=" + r.getName(),
						carta.exists());
			}
		}
		System.out.println("Controllo carte eseguito");
	}
	
	/**
	 * Controllo delle risorse se tutte sono presenti (Memory section)
	 */
	@Test
	public void testMemoryResources() {
		for (int i = 8; i > 0; i--) {
			File f = FileReaderUtils.getFile(ResourcesPath.PATH_MEMORY_HOME + i + ResourcesPath.MEMORY_CARD_EXT);
			assertTrue("File mancante per memory: " + i, f.exists());
		}
	}

}
