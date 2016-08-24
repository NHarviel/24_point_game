import javax.swing.*;

/**
 * Created by Nicholas on 6/30/2015.
 */
public class Card {
    //Value of the card
    private int cardValue;

    //Image of the card
    private ImageIcon imageIcon;

    public Card(int cardValue, ImageIcon imageIcon){
        this.cardValue = cardValue;
        this.imageIcon = imageIcon;
    }

    public int getCardValue(){
        return this.cardValue;
    }

    public ImageIcon getImageIcon(){
        return this.imageIcon;
    }
}
