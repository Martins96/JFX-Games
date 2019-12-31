package mypackage.scene.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand {
	private int total;
	private int soft;
	private java.util.List<Card> hand = new ArrayList<>();

	public void addCard(Card card) {
		total += card.getValue();
		if (card.getRank() == Rank.ACE) {
			soft += 1;
		}
		if (soft > 0) {
			if (total > 21) {
				total -= 10;
				soft -= 1;
			}
		}
		hand.add(card);
	}

	public Card getCard(int index) {
		return hand.get(index);
	}

	public void discardHand() {
		hand.clear();
		total = 0;
		soft = 0;
	}

	public int getNumberOfCards() {
		return hand.size();
	}

	public void sort() {
		Collections.sort(hand, new SortCard());
	}

	public boolean isEmpty() {
		return hand.isEmpty();
	}

	public int findCard(Card card) {
		return hand.indexOf(card);
	}

	public int getSoft() {
		return soft;
	}

	public int evaluateHand() {
		return total;
	}

	@Override
	public String toString() {
		return hand.toString();
	}

	private class SortCard implements Comparator<Card> {
		public int compare(Card a, Card b) {
			return a.getRank().getValue() - b.getRank().getValue();
		}
	}
}