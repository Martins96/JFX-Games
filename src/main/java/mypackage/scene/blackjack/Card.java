package mypackage.scene.blackjack;

import java.io.File;
import java.io.InputStream;

import javafx.scene.image.Image;
import mypackage.util.constants.FileReaderUtils;
import mypackage.util.constants.ResourcesPath;

public class Card {
   private Suit suitValue;
   private Rank rankValue;
   private Image cardImage;

   public Card( Suit suit, Rank rank, Image cardFace ) {
      cardImage = cardFace;
      suitValue = suit;
      rankValue = rank;
   }

   public static String getFilename( Suit suit, Rank rank ) {
      return ResourcesPath.PATH_BLACKJACK_CARD_HOME
    		  + rank.getSymbol() + suit.getSymbol() + ResourcesPath.BALCKJACK_CARD_EXT;
   }
   
   public static InputStream getInputStream( Suit suit, Rank rank ) {
	      return FileReaderUtils.getInputStream(getFilename(suit, rank));
	   }
   
   public static File getFile( Suit suit, Rank rank ) {
	      String path = getFilename(suit, rank);
	      return FileReaderUtils.getFile(path);
	   }

   public Suit getSuit() {
      return suitValue;
   }

   public Rank getRank() {
      return rankValue;
   }
   
   public int getValue() {
       String rank = rankValue.getSymbol();  
       try{
           // try to turn it into an integer 
           return Integer.parseInt(rank);  
       } catch (Exception ex){
           
           // we failed, so it is a letter
           if(rank.equals("a")){
               // it is an ace
               return 11; 
           } else {
               // it is a face card 
               return 10; 
           }
       }
   }

   public Image getCardImage() {
      return cardImage;
   }

   @Override
   public String toString() {
      return rankValue.toString() + " di " + suitValue.toString();
   }

   public String rankToString() {
      return rankValue.toString();
   }

   public String suitToString() {
      return suitValue.toString();
   }
}



    