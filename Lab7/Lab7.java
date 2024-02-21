public class Lab7 {
    public static void main(String[] args) {

        // Determine the number of lines in the text file
        TextFileInput inputFileCount = new TextFileInput(args[0]);
        int count = 0;
        while (inputFileCount.readLine() != null) {
            count++;
        }

        // Reset the text file to go back to the start
        TextFileInput inputFile = new TextFileInput(args[0]);

        //create a 2d array and display it using the methods
        int[][] myArray = fillArray(inputFile, count);
        printArray(myArray);
        System.out.println("\n");
        printArrayEven(myArray);

    }// main

    public static int[][] fillArray(TextFileInput inputFile2, int lines) {
        // Read in lines and store words in wordArray
        String[] wordArray = new String[lines];
        int[] numArray = new int[lines];
        for (int i = 0; i < lines; i++) {
            wordArray[i] = inputFile2.readLine();
            // convert the current index to an int to use with the sum() and average() funcs
            numArray[i] = Integer.parseInt(wordArray[i]);
        }

        // take the first two lines to make an array of the size
        int[][] twoDArray = new int[numArray[1]][numArray[0]];

        // fill the array with the rest of the file's numbers
        int index = 2;
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                twoDArray[i][j] = numArray[index];
                index++;
            }
        }
        return twoDArray;
    }

    //
    private static void printArray(int[][] theArray) {
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < theArray[i].length; j++)
                display(theArray[i][j]);
            System.out.println();
        }
    }

    private static void display(int num) {
        System.out.print(num + "\t");
    }

    private static void printArrayEven(int[][] theArray) {
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < theArray[i].length; j++)
                if (theArray[i][j] % 2 == 1)
                    System.out.print("*\t");
                else
                    display(theArray[i][j]);
            System.out.println();
        }
    }
}// Lab7
