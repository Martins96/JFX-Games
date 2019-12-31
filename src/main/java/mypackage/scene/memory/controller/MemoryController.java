package mypackage.scene.memory.controller;

import java.util.Observable;

import mypackage.scene.memory.gui.Card;

public class MemoryController extends Observable {

	public static final String CHECK = "check";

	private Card firstCard;
	private Card secondCard;
	private boolean checkTime;

	public MemoryController() {
	}

	public Card getFirstCard() {
		return firstCard;
	}

	public void setFirstCard(Card firstCard) {
		this.firstCard = firstCard;
	}

	public Card getSecondCard() {
		return secondCard;
	}

	public void setSecondCard(Card secondCard) {
		this.secondCard = secondCard;
	}

	public void check() {
		setChanged();
		notifyObservers(CHECK);
	}

	public boolean isCheckTime() {
		return checkTime;
	}

	public void setCheckTime(boolean checkTime) {
		this.checkTime = checkTime;
	}

}
