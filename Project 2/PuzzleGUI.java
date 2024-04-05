
//Name: Yousuf Ahmed
//LAB: 212 111F with Arianna Campbell
import javax.swing.*;
import java.awt.*;

public class PuzzleGUI extends JFrame {
    private JTextArea wordsTextArea;
    public int score;
    public SortedWordList sortedgui = new SortedWordList();

    public PuzzleGUI(String letters, UnsortedWordList unsorted, String Input) {
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
    }// PuzzleGUI

    /*
     * This method checks the result from CheckWord and returns a MessageDialog
     * corresponding to the int returned
     */
    public void checkResult(int result, String word) {
        if (result == 0) {
            score += 3;
            sortAdd(word);
            JOptionPane.showMessageDialog(null, "The word " + word + " is on the list.", "Word Game",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if (result == 1) {
            JOptionPane.showMessageDialog(null, "The word " + word + " is shorter than 5 letters.", "Word Game",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (result == 2) {
            JOptionPane.showMessageDialog(null, "The word " + word + " has a letter not in the list of letters",
                    "Word Game", JOptionPane.ERROR_MESSAGE);
        }
        if (result == 3) {
            JOptionPane.showMessageDialog(null, "The word " + word + " is not on the list.", "Word Game",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (result == 4) {
            JOptionPane.showMessageDialog(null,
                    "The word " + word + " must contain the first letter of the subject letters ", "Word Game",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (result == 5) {
            score++;
            sortAdd(word);
            JOptionPane.showMessageDialog(null, "The word " + word + " is on the list.", "Word Game",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    } // checkResult

    public void sortAdd(String input) {
        sortedgui.add(new Word(input));
        // Clear the text area and display the sorted list
        wordsTextArea.setText(" \tScore : " + score + '\n');
        LinkedListIterator lli2 = sortedgui.reset();
        while (lli2.hasNext()) {
            wordsTextArea.append(lli2.next() + '\n');
        }
    }
}// PuzzleGUI class