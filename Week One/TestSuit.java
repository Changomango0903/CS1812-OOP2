public class TestSuit {

  public static void main(String[] args) {
    Suit a = Suit.HEARTS;
    Suit b = Suit.HEARTS;
    Suit c = Suit.CLUBS;
    
    System.out.println(a.toString() + " = " + b.toString() + " ? " + a.equals(b));
    System.out.println(a.toString() + " = " + c.toString() + " ? " + a.equals(c));
    System.out.println(a.equals(c));

    Suit[] suits = Suit.values();
    for(int i = 0; i < suits.length; i++){
      System.out.println(suits[i].toString());
    }
  }
}
