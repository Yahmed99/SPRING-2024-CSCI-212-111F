// Name: Yousuf Ahmed
// LAB: 212 111F with Arianna Campbell

import javax.swing.*;

public class Project2 {
    public static String letters;

    public static void main(String[] args) {
        // create a 2d array using the words in the textfile
        UnsortedWordList unsorted = new UnsortedWordList();
        fillArray(args[0], unsorted);
        letters = setLetter(unsorted);
        // initialize the gui and repeatedly ask for input, then check the input
        String inputWord = " ";
        PuzzleGUI gui = new PuzzleGUI(letters, unsorted, inputWord);
        while (true) {
            inputWord = JOptionPane.showInputDialog(null,
                    "Use the letters to make words", "Word Game", JOptionPane.QUESTION_MESSAGE);
            if (inputWord != null && inputWord.equalsIgnoreCase("STOP")) {
                gui.dispose();
                break;
            }
            gui.checkResult(checkWord(inputWord, unsorted), inputWord);
        }
    }// main

    /*
     * This function takes the words in inputFile and fills an array of strings
     * with the words in the file
     */
    public static void fillArray(String args, UnsortedWordList list) {
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

        // fillList(wordArray, list);
        for (int i = 0; i < wordArray.length; i++) {
            list.add(new Word(wordArray[i]));
        }
    }// fillArray

    public static String setLetter(UnsortedWordList List) {
        LinkedListIterator lli = List.reset();
        return lli.next();
    }

    /*
     * -This function checks the findMe and returns an integer based on the
     * following
     * 0 - the input word is valid and has the first letter of the list of letters
     * 1- the input is less than 5 letters long
     * 2- the input has a letter not in the list of letters
     * 3 - the input has all letters but does not match a word on the list
     * 4 - the input has all letters but does not have the first letter on the list
     * 5 - the input word is valid and has all letters in the list of letters
     * The result gets used in checkResult to give the user a corresponding message
     * box
     */
    public static int checkWord(String findMe, UnsortedWordList theList) {

        if (checkFirstLetter(findMe, letters)) {
            LinkedListIterator lli = theList.reset();
            while (lli.hasNext()) {
                // return 0 if findMe matches all on the list (3 points)
                if (checkAllLetters(findMe, letters))
                    return 0;
                // return 5 if findMe matches one on the list (1 point)
                else if (findMe.equals(lli.next()))
                    return 5;
            }
        }
        // return 4 if the first letter of the sample word is not in findMe
        if (!checkFirstLetter(findMe, letters))
            return 4;
        // return 1 if findMe is less than 5 letters long
        if (findMe.length() < 5)
            return 1;

        // return 2 if findMe has a letter not in the list
        if (checkLetters(findMe, letters))
            return 2;

        // return 3 if findMe does not match the list
        return 3;

    } // checkWord

    /*
     * -This method is used by CheckWord to go through the inputWord and the letters
     * given to check if inputWord has all letters given
     * j - index for inputWord
     * k - index for letters given in line 1
     * -it will return false if j has gone through the entire inputWord length
     * a.k.a.
     * all letters match
     * -returns true if j has not gone through the entire inputWord becuase the loop
     * broke prematurely (it hasnt gone through all letters so one has to be wrong)
     */
    public static boolean checkLetters(String findMe, String letterList) {
        int j = 0;
        int k = 0;
        while (j < findMe.length()) {
            /*
             * -the program would get stuck here so i put an if statement that will break if
             * k has gone through every letter in the list (no letter was matched)
             */
            if (k == letterList.length())
                break;
            /*
             * -This while loop checks through the current index of inputWord and goes
             * through the letters one by one
             */
            while (k < letterList.length()) {
                /*
                 * -if the current letter matches, it will reset k to get it
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

    /*
     * This method checks the if the input word contains the first letter in the
     * letter list
     * true - it contains the first letter
     * false - it does not contain the first letter
     */
    public static boolean checkFirstLetter(String findMe, String letterList) {
        boolean hasLetter = false;
        for (int k = 0; k < findMe.length(); k++) {
            if ((findMe.charAt(k)) == (letterList.charAt(0))) {
                hasLetter = true;
            }
        }
        return hasLetter;
    }// checkFirstLetter

    /*
     * this method checks if the word contains all letters in the list in order to
     * award 3 points
     */
    public static boolean checkAllLetters(String findMe, String letterList) {
        boolean hasAllLetters = true;
        for (int i = 0; i < letterList.length(); i++) {
            char letter = letterList.charAt(i);
            // Check if the letter is present in the guessed word
            if (findMe.indexOf(letter) == -1) {
                // Letter not found return false
                hasAllLetters = false;
            }
        }
        return hasAllLetters;
    }// checkAllLetters
}// Project2
