import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nicholas on 6/30/2015.
 */
public class TwentyFourPointGame extends JFrame {
    DisplayCards displayCards = new DisplayCards();


    public TwentyFourPointGame() {
        setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        JLabel expressionLabel = new JLabel("Enter an Expression");
        final JTextField expessionField = new JTextField(20);
        JButton jbtRefresh = new JButton("Refresh");
        jbtRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayCards.drawFourCards();
                expessionField.setText("");
            }
        });
        panel1.add(jbtRefresh, BorderLayout.EAST);
        add(panel1, BorderLayout.NORTH);
        add(displayCards, BorderLayout.CENTER);
        JPanel panel2 = new JPanel(new FlowLayout());
        JButton jbtVerify = new JButton("Verify");
        panel2.add(expressionLabel);
        panel2.add(expessionField);
        panel2.add(jbtVerify);
        add(panel2, BorderLayout.SOUTH);
        jbtVerify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (EvaluateExpression.compareOperandsToCardValues(expessionField.getText(), displayCards.getCardValues())){
                        int result = EvaluateExpression.evaluateExpression(expessionField.getText());
                        if(result == 24){
                            JOptionPane.showMessageDialog(null, "Correct", "Message", JOptionPane.INFORMATION_MESSAGE);
                        }else {
                            JOptionPane.showMessageDialog(null, "Incorrect expression, try again", "Message", JOptionPane.WARNING_MESSAGE);
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Use the value of the four cards", "Error", JOptionPane.ERROR_MESSAGE);
                    }


                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Enter a valid expression", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new TwentyFourPointGame();
        frame.setTitle("Twenty Four Point Game");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}