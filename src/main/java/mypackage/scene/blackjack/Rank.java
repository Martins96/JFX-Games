package mypackage.scene.blackjack;

import java.util.*;

public class Rank {
	private String name;
	private String symbol;
	private int value;

	public final static Rank ACE = new Rank("Asso", "a", 1);
	public final static Rank TWO = new Rank("Due", "2", 2);
	public final static Rank THREE = new Rank("Tre", "3", 3);
	public final static Rank FOUR = new Rank("Quattro", "4", 4);
	public final static Rank FIVE = new Rank("Cinque", "5", 5);
	public final static Rank SIX = new Rank("Sei", "6", 6);
	public final static Rank SEVEN = new Rank("Sette", "7", 7);
	public final static Rank EIGHT = new Rank("Otto", "8", 8);
	public final static Rank NINE = new Rank("Nove", "9", 9);
	public final static Rank TEN = new Rank("Dieci", "t", 10);
	public final static Rank JACK = new Rank("Jack", "j", 11);
	public final static Rank QUEEN = new Rank("Donna", "q", 12);
	public final static Rank KING = new Rank("Re", "k", 13);

	public final static java.util.List<Rank> VALUES = Collections.unmodifiableList(
			Arrays.asList(new Rank[] { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }));

	private Rank( String nameValue, String symbolValue, int value ) {
      this.name = nameValue;
      this.symbol = symbolValue;
      this.value = value;
   }

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getValue() {
		return this.value;
	}
}