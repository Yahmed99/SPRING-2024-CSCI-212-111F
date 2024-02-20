import javax.swing.*;

public class Lab6 {
    public static void main(String[] args) {
        /*
         * convert string to int:
         * int num = Integer.parseInt("10");
         */

        /*
         * 1) Read in each number as a string, convert to integer and add it to the int
         * array
         * text file input in combination with args[0]
         * 
         * Step 1 - Instantiated an object bound to 'inputfile' that will read in the
         * contents of whatever 'args[0]' resolves
         */
        TextFileInput inputFile = new TextFileInput(args[0]);

        // Step 2 - Read in lines and store words in wordArray
        String[] wordArray = new String[14];
        int[] numArray = new int[14];

        for (int i = 0; i < 14; i++) {
            wordArray[i] = inputFile.readLine();
            // convert the current index to an int to use with the sum() and average() functions
            numArray[i] = Integer.parseInt(wordArray[i]);
        }

        average(numArray, 14);
    }// main

    /*
     * 2) Calculate & display the sums of the numbers in the array
     *
     * Define the logic with the sum() method
     * Call it with the array and the size
     */
    public static int sum(int[] myArray, int myArraySize) {
        int ans = 0;
        for (int i = 0; i < myArraySize; i++) {
            ans += myArray[i];
        }
        JOptionPane.showMessageDialog(null, "The sum of the numbers is " + ans);
        return ans;
    }// sum

    // 3) Calculate & display the avearge of the numbers in the array
    /*
     * Define the logic with the array() method
     * Call it with the array and the size
     */
    public static int average(int[] myArray, int myArraySize) {
        // since sum() is called here we dont need to call is in the main function
        int sum = sum(myArray, myArraySize);
        int avg = sum / myArraySize;
        JOptionPane.showMessageDialog(null, "The average of the numbers is " + avg);
        return avg;
    }// average
}// Lab6
