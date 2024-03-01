import javax.swing.*;
import java.awt.*;

public class PuzzleGUI extends JFrame {
    private JTextArea wordsTextArea;
    public int score;

    public PuzzleGUI(String letters, String[] solutions, String Input) {
        int score = 0;
        this.score = score;

        setTitle("Word Game GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(1, 2));

        JLabel lettersLabel = new JLabel("Letters: " + letters);
        add(lettersLabel);

        wordsTextArea = new JTextArea();
        wordsTextArea.setEditable(false);
        add(new JScrollPane(wordsTextArea));

        setVisible(true);
    }//PuzzleGUI

/*
 * This method checks the result from CheckWord and returns a MessageDialog corresponding to the int returned
 */
    public void checkResult(int result, String word) {
        if (result == 0) {
            score++;
            wordsTextArea.append(word + " \tScore : " + score + '\n');
            JOptionPane.showMessageDialog(null, "The word " + word + " is on the list.","Word Game",JOptionPane.INFORMATION_MESSAGE);
        }
        if (result == 1) {
            JOptionPane.showMessageDialog(null, "The word " + word + " is shorter than 5 letters.","Word Game",JOptionPane.ERROR_MESSAGE);
        }
        if (result == 2) {
            JOptionPane.showMessageDialog(null, "The word " + word + " has a letter not in the list of letters","Word Game",JOptionPane.ERROR_MESSAGE);
        }
        if (result == 3) {
            JOptionPane.showMessageDialog(null, "The word " + word + " is not on the list.","Word Game",JOptionPane.ERROR_MESSAGE);
        }
    } // wordIsThere


}//PuzzleGUI class