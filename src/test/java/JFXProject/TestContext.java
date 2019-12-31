package JFXProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mypackage.context.AppContext;
import mypackage.context.ContextValues;

public class TestContext {
	
	/**
	 * Controlli su insert e get con cancellazione (insert null) nel contesto applicativo
	 */
	@Test
	public void testContext() {
		Long time = System.currentTimeMillis();
		String overwrite = 
				new String(new char[]{'o', 'v', 'e', 'r', 'w', 'r', 'i', 't', 'e'});
		AppContext.addInContext(ContextValues.MENU, time);
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertNotEquals(AppContext.getFromContext(ContextValues.MENU), System.currentTimeMillis());
		
		AppContext.addInContext(ContextValues.MENU, overwrite);
		
		assertTrue(AppContext.getFromContext(ContextValues.MENU) instanceof String);
		assertNotEquals(AppContext.getFromContext(ContextValues.MENU), time);
		assertNotEquals(AppContext.getFromContext(ContextValues.MENU, String.class), time.toString());
		assertEquals(AppContext.getFromContext(ContextValues.MENU, String.class), overwrite);
		
		AppContext.addInContext(ContextValues.MENU, null);
		assertNull(AppContext.getFromContext(ContextValues.MENU));
		assertNull(AppContext.getFromContext(ContextValues.BLACKJACK));
	}
	
	
}
