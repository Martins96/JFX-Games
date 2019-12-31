package mypackage.scene.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mypackage.context.AppContext;
import mypackage.context.ContextValues;
import mypackage.scene.blackjack.Blackjack;
import mypackage.scene.info.InfoPane;
import mypackage.scene.memory.application.MemoryGame;
import mypackage.scene.rewards.Reward1;
import mypackage.scene.rewards.Reward2;
import mypackage.scene.rewards.Reward3;
import mypackage.scene.sassocartaforbice.SCF;
import mypackage.scene.tetris.Tetris;

public class MenuController {

	@FXML
	private Button sez1;
	@FXML
	private Button sez2;
	@FXML
	private Button sez3;
	@FXML
	private Button rewardSez1;
	@FXML
	private Button rewardSez2;
	@FXML
	private Button rewardSez3;
	@FXML
	private Button info;
	@FXML
	private Button specialgame;

	public void onShowChecks() {
		Object rew1 = AppContext.getFromContext(ContextValues.REWARD1);
		Object rew2 = AppContext.getFromContext(ContextValues.REWARD2);
		Object rew3 = AppContext.getFromContext(ContextValues.REWARD3);
		if (checkRewards(rew1))
			rewardSez1.setVisible(true);
		else
			rewardSez1.setVisible(false);
		
		if (checkRewards(rew2))
			rewardSez2.setVisible(true);
		else
			rewardSez2.setVisible(false);
		
		if (checkRewards(rew3))
			rewardSez3.setVisible(true);
		else
			rewardSez3.setVisible(false);
	}

	private boolean checkRewards(Object rew1) {
		if (rew1 != null) 
			if (rew1 instanceof Boolean && ((Boolean)rew1).booleanValue())
				return true;
		return false;
	}

	@FXML
	public void startSez1() {
		Stage scf = new SCF();
		AppContext.addInContext(ContextValues.SCF, scf);
		Stage menu = AppContext.getFromContext(ContextValues.MENU, Stage.class);
		menu.hide();
		scf.show();
	}

	@FXML
	public void startSez2() {
		Stage blackjack = new Blackjack();
		AppContext.addInContext(ContextValues.BLACKJACK, blackjack);
		Stage menu = AppContext.getFromContext(ContextValues.MENU, Stage.class);
		menu.hide();
		blackjack.show();
	}

	@FXML
	public void startSez3() {
		Stage memory = new MemoryGame();
		AppContext.addInContext(ContextValues.MEMORY, memory);
		Stage menu = AppContext.getFromContext(ContextValues.MENU, Stage.class);
		menu.hide();
		memory.show();
	}
	
	@FXML
	public void info() {
		Stage info = new InfoPane();
		AppContext.addInContext(ContextValues.INFO, info);
		Stage menu = AppContext.getFromContext(ContextValues.MENU, Stage.class);
		menu.hide();
		info.show();
	}

	@FXML
	public void rewardSez1() {
		Stage rew1 = new Reward1();
		AppContext.addInContext(ContextValues.REWARD1PANE, rew1);
		Stage menu = AppContext.getFromContext(ContextValues.MENU, Stage.class);
		menu.hide();
		rew1.show();
	}

	@FXML
	public void rewardSez2() {
		Stage rew2 = new Reward2();
		AppContext.addInContext(ContextValues.REWARD2PANE, rew2);
		Stage menu = AppContext.getFromContext(ContextValues.MENU, Stage.class);
		menu.hide();
		rew2.show();
	}

	@FXML
	public void rewardSez3() {
		Stage rew3 = new Reward3();
		AppContext.addInContext(ContextValues.REWARD3PANE, rew3);
		Stage menu = AppContext.getFromContext(ContextValues.MENU, Stage.class);
		menu.hide();
		rew3.show();
	}
	
	public boolean isReward1Unlock() {
		return rewardSez1.isVisible();
	}
	public boolean isReward2Unlock() {
		return rewardSez2.isVisible();
	}
	public boolean isReward3Unlock() {
		return rewardSez3.isVisible();
	}
	
	@FXML
	public void tetris() {
		Stage tetris = new Tetris();
		AppContext.addInContext(ContextValues.TETRIS, tetris);
		Stage menu = AppContext.getFromContext(ContextValues.MENU, Stage.class);
		tetris.show();
		menu.hide();
		
	}

}
