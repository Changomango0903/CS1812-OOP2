public class TestMixedPair{
  public static void main(String[] args) {
    MixedPair<Integer, Boolean> iB = new MixedPair<Integer, Boolean>(69, true);
    MixedPair<Character, Double> cD = new MixedPair<Character,Double>('A', 3.141592);
    System.out.println(iB);
    System.out.println(cD);
  }
}
