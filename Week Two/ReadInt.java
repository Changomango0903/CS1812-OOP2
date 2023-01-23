import java.util.Scanner;
import java.util.InputMismatchException;

class ReadInt {
  public static void main(String[] args) {
    boolean gotInt = false;
    int n;
    Scanner s = new Scanner(System.in);
    do {
        try {
          System.out.println("Enter an Integer: ");
          n = s.nextInt();
        System.out.println("Good Job!");
          gotInt = true;
        }
        catch(Exception e) {
          e.printStackTrace();
          System.out.println("The input has to be an integer!");
          s.next();
        }
    } while (!gotInt);
  }
}
