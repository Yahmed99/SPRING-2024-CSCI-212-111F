import java.util.*;

public class TwoDimArray {

    public static TextFileInput myFile;
    public static StringTokenizer myTokens;
    public static String line;

    public static void main(String[] args) {
        myFile = new TextFileInput(args[0]);
        line = myFile.readLine();
		myTokens = new StringTokenizer(line,",");
        int rowCount = Integer.parseInt(myTokens.nextToken());
        int colCount = Integer.parseInt(myTokens.nextToken());

        int[][] myArray = new int[rowCount][colCount];
		fillArray(myArray);
        printArray(myArray);
        printArrayEven(myArray);
    }

	public static void fillArray(int[][]Array){		
        for (int i = 0; i < Array.length; i++) {
            line = myFile.readLine();
            myTokens = new StringTokenizer(line,",");
            for (int j = 0; j < Array[0].length; j++) {
                Array[i][j] = Integer.parseInt(myTokens.nextToken());
            }
        }
	}

    private static void printArray(int[][] theArray) {
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < theArray[i].length; j++) {
                display(theArray[i][j]);
            }
            System.out.println();
        }
		System.out.println();
    }

    private static void display(int num) {
        System.out.print(num + " \t");
    }

    private static void printArrayEven(int[][] theArray) {
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < theArray[i].length; j++) {
                if (theArray[i][j] % 2 == 1)
                    System.out.print("*\t");
                else
                    display(theArray[i][j]);
            }
            System.out.println();
        }
    }
}
