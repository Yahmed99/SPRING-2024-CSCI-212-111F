import javax.swing.*;

public class backProject1 {
    public static void main(String[] args) {

        // Determine the number of lines in the text file
        TextFileInput inputFileCount = new TextFileInput(args[0]);
        int count = 0;
        while (inputFileCount.readLine() != null) {
            count++;
        }

        // Reset the text file to go back to the start
        TextFileInput inputFile = new TextFileInput(args[0]);

        // create a 2d array using the words in the textfile
        String[] myArray = fillArray(inputFile, count);
        // System.out.println(Arrays.toString(myArray));
        while (true) {
            String inputWord = JOptionPane.showInputDialog(null, "Use the letters to make words");
            checkResult(checkWord(inputWord, myArray), inputWord);
        }
    }// main

    /*
     * This function takes the words in inputFile and fills an array of strings with
     * the words in the file
     */
    public static String[] fillArray(TextFileInput inputFile2, int lines) {

        // Read in lines and store words in wordArray
        String[] wordArray = new String[lines];
        for (int i = 0; i < lines; i++) {
            wordArray[i] = inputFile2.readLine();
        }

        return wordArray;
    }

    /*
     * This function checks the inputWord and returns an integer based on the
     * following
     * 0 - The inputWord matches a word on the list
     * 1 - The inputWord is longer than 7 characters
     * 2 - The inputWord has a letter that is not one of the seven letters given
     * 3 - The inputWord is not in the solution list
     */
    public static int checkWord(String findMe, String[] theList) {
        // return 0 if inputWord matches one on the list
        for (int i = 1; i < theList.length; i++) {
            if (findMe.equals(theList[i])) {
                return 0;
            }
        }

        // Check the length of inputWord
        if (findMe.length() < 5) {
            return 1;
        }

        if (checkLetters(findMe, theList) == true) {
            return 2;
        }

        // return 3 if the word does not match the list (does not fall under other
        // cases)
        return 3;

    } // checkWord

    /*
     * This method checks the result from CheckWord and returns a JOptionPane
     * corresponding to the int returned
     */
    public static void checkResult(int result, String word) {
        if (result == 0) {
            JOptionPane.showMessageDialog(null, "The word " + word + " is on the list.");
        }
        if (result == 1) {
            JOptionPane.showMessageDialog(null, "The word " + word + " is shorter than 5 letters.");
        }
        if (result == 2) {
            JOptionPane.showMessageDialog(null, "The word " + word + " has a letter not in the list of letters");
        }
        if (result == 3) {
            JOptionPane.showMessageDialog(null, "The word " + word + " is not on the list.");
        }
    } // wordIsThere

    /*
     * This method is used by CheckWord to go through the inputWord and the letters
     * given to check if inputWord has all letters given
     * j - index for inputWOrd
     * k - index for letters given in line 1
     * it will return false if j has gone through the entire inputWord length a.k.a.
     * all letters match
     * returns true if j has not gone through the entire inputWord becuase the loop
     * broke prematurely
     */

    public static boolean checkLetters(String findMe, String[] theList) {
        int j = 0;
        int k = 0;
        while (j < findMe.length()) {
            // the program will get stuck here so the if statement will break if k has gone
            // through every letter in the list (no letter was matched)
            if (k == 7)
                break;
            // This while loop checks through the current index of inputWord and goes
            // through the letters one by one
            while (k < theList[0].length()) {
                // if statement checks if the current letter matches, it will reset k to get it
                // ready to check through the next letter
                if ((findMe.charAt(j)) == (theList[0].charAt(k))) {
                    j++;
                    k = 0;
                    break;
                }
                // if no matching letter is found, go to next index
                k++;
            }
        }
        if (j < findMe.length()) {
            return true;
        }
        return false;
    }// CheckLetters
}// Project1
