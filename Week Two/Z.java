public class Z {

  private static String silly() {
    try {
      return "A";
    }
    catch (Exception ex) {
      System.out.println("B");
    }
    finally {
      System.out.println("C");
    }
    return "D";
  }

  public static void main(String[] args) {
    System.out.println( silly() );
  }

}
