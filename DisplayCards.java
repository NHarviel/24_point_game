import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by Nicholas on 6/30/2015.
 */
public class DisplayCards extends JPanel {
    private static final int FINAL_CARDS_NUMBER = 52;
    private Stack<Card> cards;
    private Stack<Card> drawnCards;
    private JLabel[] cardLabels = new JLabel[4];

    public DisplayCards(){
        setLayout(new FlowLayout());
        //Loop through and change the card image for each card clicked

        for (int i = 0; i < 4; i++) {
            cardLabels[i] = new JLabel();
            add(cardLabels[i]);
        }
        drawFourCards();
    }

    public void drawFourCards() {
        shuffleDeck();
        for (int i = 0; i < 4; i++) {
            Card c = cards.pop();
            drawnCards.push(c);
            cardLabels[i].setIcon(c.getImageIcon());
        }
    }

    public Stack<Integer> getCardValues(){
        Stack<Integer> cardValues = new Stack<Integer>();
        for(Card card : drawnCards){
            cardValues.push(card.getCardValue());
        }

        return cardValues;
    }

    public void shuffleDeck(){
        cards = new Stack<Card>();
        drawnCards = new Stack<Card>();
        //Set the deck of cards array to images of cards
        for (int i = 1; i <= FINAL_CARDS_NUMBER; i++) {
            int cardValue = i % 13;
            if(cardValue == 0){
                cardValue = 13;
            }
            ImageIcon image = new ImageIcon(new ImageIcon("images/" + i + ".png").getImage().getScaledInstance(120, 180, java.awt.Image.SCALE_SMOOTH));
            Card card = new Card(cardValue, image);
            cards.push(card);
        }
        Collections.shuffle(cards);
    }

}