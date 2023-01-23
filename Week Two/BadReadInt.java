import java.util.Scanner;
import java.util.InputMismatchException;

class BadReadInt {
  public static void main(String[] args) {
    int n;
    boolean gotInt = false;
    Scanner s = new Scanner(System.in);
    // do{
    //   try{
    //     System.out.println("Enter an Integer: ");
    //     n = s.nextInt();
    //     System.out.println("Good Job!");
    //     gotInt = true;
    //   } catch(Exception e){
    //     e.printStackTrace();
    //     System.out.println("The input has to be an integer!");
    //   }
    // } while (!gotInt);
    //
    while(gotInt != true){
      try{
        System.out.println("Enter an Integer: ");
        n = s.nextInt();
        System.out.println("Good Job!");
        gotInt = true;
      } catch (Exception e){
        e.printStackTrace();
        System.out.println("The input has to be an integer!");
      }
    }
    // System.out.print("Enter an integer: ");
    // n = s.nextInt();
    // System.out.println("Good job!");
  }
}
