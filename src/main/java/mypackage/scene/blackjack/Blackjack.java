package mypackage.scene.blackjack;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mypackage.context.AppContext;
import mypackage.context.ContextValues;
import mypackage.scene.StagePOJO;
import mypackage.util.constants.FileReaderUtils;
import mypackage.util.constants.ResourcesPath;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Blackjack extends StagePOJO {
	private final Deck deck = new Deck(1);
	private final Hand hand = new Hand();
	private final Hand dealer = new Hand();

	private boolean busted;
	private boolean playerTurn;

	FlowPane cards = new FlowPane(Orientation.HORIZONTAL);
	FlowPane dealerCards = new FlowPane(Orientation.HORIZONTAL);
	Label totalLabel = new Label();
	Label totalLabelDealer = new Label();

	Label dealerLbl = new Label("La mano dealer");
	Label playerLbl = new Label("La tua mano");

	Label status = new Label();
	Image imageback = new Image(FileReaderUtils.getInputStream(ResourcesPath.PATH_BALCKJACK_TABLE));
	
	public Blackjack() {
		super();
		start();
	}


	public void drawCard(Hand hand, FlowPane pane, Label l) {
		try {
			Card card = deck.dealCard();
			ImageView img = new ImageView(card.getCardImage());
			pane.getChildren().add(img);
			hand.addCard(card);

			int handTotal = hand.evaluateHand();

			StringBuilder total = new StringBuilder();
			if (hand.getSoft() > 0) {
				total.append(handTotal - 10).append("/");
			}
			total.append(handTotal);
			l.setText(total.toString());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void newDeck() {
		deck.restoreDeck();
		deck.shuffle();
	}

	public void newHand() {
		// check if we should shuffle
		if (deck.getNumberOfCardsRemaining() <= deck.getSizeOfDeck() * 0.2) {
			newDeck();
		}

		// clear everything
		hand.discardHand();
		dealer.discardHand();
		cards.getChildren().removeAll(cards.getChildren());
		dealerCards.getChildren().removeAll(dealerCards.getChildren());
		totalLabel.setText("");
		totalLabelDealer.setText("");

		busted = false;
		playerTurn = true;

		// draw cards for the initial hands, player gets 2, dealer 1
		drawCard(hand, cards, totalLabel);
		drawCard(dealer, dealerCards, totalLabelDealer);
		drawCard(hand, cards, totalLabel);

		status.setText("Tuo turno");
	}

	
	public void start() {
		// Update all text colors and fonts
		totalLabel.setFont(new Font("Arial", 24));
		totalLabel.setTextFill(Color.web("#FFF"));

		totalLabelDealer.setFont(new Font("Arial", 24));
		totalLabelDealer.setTextFill(Color.web("#FFF"));

		status.setTextFill(Color.web("#FFF"));
		status.setFont(new Font("Arial", 24));

		dealerLbl.setTextFill(Color.web("#FFF"));
		dealerLbl.setFont(new Font("Arial", 24));

		playerLbl.setTextFill(Color.web("#FFF"));
		playerLbl.setFont(new Font("Arial", 24));

		BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
		BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		Background background = new Background(backgroundImage);

		Button drawbtn = new Button();
		drawbtn.setText("Pesca");
		drawbtn.setOnAction((e) -> {
			if (playerTurn == true && busted != true) {
				drawCard(hand, cards, totalLabel);

				if (hand.evaluateHand() > 21) {
					// you busted
					status.setText("Superato 21, hai perso");
					busted = true;
					playerTurn = false;
				}
			}
		});

		Button standbtn = new Button();
		standbtn.setText("Fermati");
		standbtn.setOnAction((e) -> {
			if (playerTurn == true && busted != true) {
				playerTurn = false;
				while (dealer.evaluateHand() < 17) {
					drawCard(dealer, dealerCards, totalLabelDealer);
				}

				int playerTotal = hand.evaluateHand();
				int dealerTotal = dealer.evaluateHand();


				if (dealerTotal <= 21 && playerTotal == dealerTotal) {
					// tie, push
					status.setText("Pareggio, il dealer vince");
				} else if (dealerTotal <= 21 && playerTotal <= dealerTotal) {
					// you lost
					status.setText("Hai perso");
				} else {
					// you won
					status.setText("Hai vinto!");
					AppContext.addInContext(ContextValues.REWARD2, new Boolean(true));
				}
			}
		});

		Button newbtn = new Button();
		newbtn.setText("Nuova mano");
		newbtn.setOnAction((e) -> {
			newHand();
		});
		
		Button homeBtn = new Button();
		homeBtn.setText("Menu");
		homeBtn.setOnAction((e) -> {
			backToMenu();
		});

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(10, 11, 11, 12));
		grid.setHgap(5.5);
		grid.setVgap(5.5);

		grid.add(dealerCards, 0, 0, 3, 1);
		grid.add(dealerLbl, 0, 1);
		grid.add(totalLabelDealer, 1, 1, 2, 1);

		// padding
		Pane p = new Pane();
		p.setPrefSize(0, 100);
		grid.add(p, 0, 2);

		grid.add(cards, 0, 3, 3, 1);
		grid.add(playerLbl, 0, 4);
		grid.add(totalLabel, 1, 4, 2, 1);
		grid.add(drawbtn, 0, 5);
		grid.add(standbtn, 1, 5);
		grid.add(newbtn, 2, 5);
		grid.add(status, 0, 6, 3, 1);
		
		GridPane gridMain = new GridPane();
		gridMain.setAlignment(Pos.CENTER);
		gridMain.setPadding(new Insets(10, 10, 10, 10));
		gridMain.setMinSize(800, 600);
		
		Label emptyLbl = new Label();
		gridMain.add(homeBtn, 0, 0);
		gridMain.add(emptyLbl, 1, 0);
		gridMain.add(grid, 5, 5);
		gridMain.setBackground(background);

		Scene scene = new Scene(gridMain, 1400, 800);

		this.setTitle("BlackJack");
		this.setScene(scene);
		this.show();

		newDeck();
		newHand();
	}
	
	private void backToMenu() {
		AppContext.getFromContext(ContextValues.BLACKJACK, Stage.class).hide();
		AppContext.getFromContext(ContextValues.MENU, Stage.class).show();
	}
}
