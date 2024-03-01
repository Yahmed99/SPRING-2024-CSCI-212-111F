import javax.swing.*;

public class Project1 {
    public static void main(String[] args) {
        // create a 2d array using the words in the textfile
        String[] myArray = fillArray(args[0]);
        String inputWord = " ";
        // initialize the gui and repeatedly ask for input, then check the input
        PuzzleGUI gui = new PuzzleGUI(myArray[0], myArray, inputWord);
        while (true) {
            inputWord = JOptionPane.showInputDialog(null, "Use the letters to make words", "Word Game",
                    JOptionPane.QUESTION_MESSAGE);
            gui.checkResult(checkWord(inputWord, myArray), inputWord);
        }
    }// main

    /*
     *-This function takes the words in inputFile and fills an array of strings with
     * the words in the file
     */
    public static String[] fillArray(String args) {
        // Determine the number of lines in the text file
        TextFileInput inputFileCount = new TextFileInput(args);
        int count = 0;
        while (inputFileCount.readLine() != null) {
            count++;
        }
        // Reset the text file to go back to the start
        TextFileInput inputFile = new TextFileInput(args);
        // Read in lines and store words in wordArray
        String[] wordArray = new String[count];
        for (int i = 0; i < count; i++) {
            wordArray[i] = inputFile.readLine();
        }

        return wordArray;
    }// fillArray

    /*
     *-This function checks the findMe and returns an integer based on the
     * following
     * 0 - The findMe matches a word on the list
     * 1 - The findMe is less than 5 letters long
     * 2 - The findMe has a letter that is not one of the seven letters given
     * 3 - The findMe is not in the solution list
     */
    public static int checkWord(String findMe, String[] theList) {
        // return 0 if findMe matches one on the list
        for (int i = 1; i < theList.length; i++) {
            if (findMe.equals(theList[i])) {
                return 0;
            }
        }

        // return 1 if findMe is less than 5 letters long
        if (findMe.length() < 5) {
            return 1;
        }

        // return 2 if findMe has a letter not in the list
        if (checkLetters(findMe, theList[0]) == true) {
            return 2;
        }

        // return 3 if findMe does not match the list
        return 3;

    } // checkWord

    /*
     *-This method is used by CheckWord to go through the inputWord and the letters
     * given to check if inputWord has all letters given
     *      j - index for inputWOrd
     *      k - index for letters given in line 1
     *-it will return false if j has gone through the entire inputWord length a.k.a.
     * all letters match
     *-returns true if j has not gone through the entire inputWord becuase the loop
     * broke prematurely (it hasnt gone through all letters so one has to be wrong)
     */
    public static boolean checkLetters(String findMe, String letterList) {
        int j = 0;
        int k = 0;
        while (j < findMe.length()) {
            /*
             *-the program would get stuck here so i put an if statement that will break if
             * k has gone through every letter in the list (no letter was matched)
             */
            if (k == letterList.length())
                break;
            /*
             *-This while loop checks through the current index of inputWord and goes
             * through the letters one by one
             */
            while (k < letterList.length()) {
                /*
                 *-if the current letter matches, it will reset k to get it
                 * ready to check through the next letter
                 */
                if ((findMe.charAt(j)) == (letterList.charAt(k))) {
                    j++;
                    k = 0;
                    break;
                }
                // if no matching letter is found, go to next index of letterList
                k++;
            }
        }
        if (j < findMe.length()) {
            return true;
        }
        return false;
    }// CheckLetters
}// Project1
