package mypackage.scene.blackjack;

import java.util.Arrays;
import java.util.Collections;

public final class Suit {
   private String name;
   private String symbol; 
   
   public final static Suit CLUBS = new Suit( "Fiori", "c" );
   public final static Suit DIAMONDS = new Suit( "Quadri", "d" );
   public final static Suit HEARTS = new Suit( "Cuori", "h" );
   public final static Suit SPADES = new Suit( "Picche", "s" );
   
   public final static java.util.List<Suit> VALUES = 
      Collections.unmodifiableList( 
         Arrays.asList( new Suit[] { CLUBS, DIAMONDS, HEARTS, SPADES } ) );

   private Suit( String nameValue, String symbolValue ) {
      name = nameValue;
      symbol = symbolValue;
   }
       
   public String getName() {
       return name;
   }
 
   public String getSymbol() {
      return symbol;
   }

   @Override
   public String toString() {
      return name;
   }
}

    