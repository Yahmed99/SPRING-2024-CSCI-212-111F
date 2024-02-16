import javax.swing.*;

public class Lab5 {
	public static void main(String[] args) {

	//Step 1 - Instantiated an object bound to 'inputfile' that will read in the contents of whatever 'args[0]' resolves  
	TextFileInput inputFile = new TextFileInput(args[0]);
		
	//Step 2 - Read in lines and store words in wordArray
	String[] wordArray = new String[8];
	for(int i = 0; i <8; i++){
		wordArray[i] = inputFile.readLine();
	}

	//String[] wordArray = { "hello", "goodbye", "cat", "dog", "red", "green", "sun", "moon" };
	String isOrIsNot, inputWord;
		
	// This line asks the user for input by popping out a single window
	// with text input
	inputWord = JOptionPane.showInputDialog(null, "Enter a word in all lower case:");
	
	// if the inputWord is contained within wordArray return true
	if (wordIsThere(inputWord, wordArray)) 
		isOrIsNot = "is"; // set to is if the word is on the list
	else
		isOrIsNot = "is not"; // set to is not if the word is not on the list
	
	// Output to a JOptionPane window whether the word is on the list or not
	JOptionPane.showMessageDialog(null, "The word " + inputWord + " " + isOrIsNot + " on the list.");
} //main

	public static boolean wordIsThere(String findMe, String[] theList) {
		for(int i=0; i < theList.length; i++){
			if (findMe.equals(theList[i]))
				return true;
		}
		return false;
	} // wordIsThere
} // class Lab5
