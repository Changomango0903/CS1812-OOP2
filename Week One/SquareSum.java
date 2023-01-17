public class SquareSum{
  public static int sqSum(int n){
    if(n == 1){
      return 1;
    } else {
      return n*n + sqSum(n - 1);
    }
  }

  public static void main(String[] args){
    System.out.println(sqSum(6));
  }
}
