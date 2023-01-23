class Factorial {

  private static long fact(long n) {
    if ( n == 0 ) {
      return 1;
    } else {
      return n * fact(n-1);
    }
  }

  public static void main (String[] args) {
    try{
      long a = Long.parseLong(args[0]);
      System.out.println( fact(a) );
    }catch (Exception e){
      System.out.println("You done f**ked up");
      e.printStackTrace();
    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("Please enter an Argument");
      e.printStackTrace();
    } catch (NumberFormatException e){
      System.out.println("Please enter a valid integer");
      e.printStackTrace(); 
    }   
  }


}
