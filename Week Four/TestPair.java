public class TestPair{
  public static void main(String[] args) {
    Pair<String> pS = new Pair<String>("Hello", "World");
    System.out.println(pS.getFirst());
    System.out.println(pS.getSecond());

    Pair<Integer> pI = new Pair<Integer>(6, 9);
    System.out.println(pI.getFirst());
    System.out.println(pI.getSecond());

    System.out.println(pS);
    System.out.println(pI);
  }
}
