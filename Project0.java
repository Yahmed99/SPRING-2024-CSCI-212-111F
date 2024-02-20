import javax.swing.*;

public class Project0 {
    public static void main(String[] args) {
        //infinite loop until user exits
        while (true) {
            //initialize variables (they will reset every loop)
            String inputWord = "";
            int lower = 0, upper = 0;
            inputWord = JOptionPane.showInputDialog(null, "Please enter a sentence.");
            // check if user wants to stop
            if (inputWord.equalsIgnoreCase("stop"))
                break;
            // check the sentence one letter at a time and count the E's accordingly
            for (int i = 0; i < inputWord.length(); i++) {
                if (inputWord.charAt(i) == 'e') {
                    lower++;
                }
                if (inputWord.charAt(i) == 'E') {
                    upper++;
                }
            }
            JOptionPane.showMessageDialog(null,
                    "Number of lowercase e's: " + lower + " \n" + " Number of uppercase E's:" + upper);
        } // while
    }// main
}// Project0
