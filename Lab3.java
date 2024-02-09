public class Lab3 {
  public static void main(String[] args) {

    // i=Initialize two float variables called Farenheit and Centigrade
    float Farenheit = 0;
    float Centigrade = 0;

    // Assign 98.6 to Farenheit
    Farenheit = 98.6f;
    System.out.println("\nCurrent value of Farenheit: " + Farenheit);

    // Convert to Centigrade
    Centigrade = (5f / 9f) * (Farenheit - 32);
    System.out.println("Farenheit Converted to Centigrade: " + Centigrade + "\nFor Loop:");

    // For Loop
    for (float i = 0; i <= 40.0; i += 5.0) {
      Centigrade = (5f / 9f) * (i - 32);
      System.out.println(i + " Degrees Farenheit Converted to Centigrade: " + Centigrade);
    }
    System.out.println("While loop:"); //add spacing to look nicer

    // While Loop
    float count = 0;
    while (count <= 40.0) {
      Centigrade = (5f / 9f) * (count - 32);
      System.out.println(count + " Degrees Farenheit Converted to Centigrade: " + Centigrade);
      count += 5.0f;
    }
  }
}