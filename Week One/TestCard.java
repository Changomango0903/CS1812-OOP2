public class TestCard {
  public static void main(String[] args) {
    Card kingHearts = new Card(Rank.KING, Suit.HEARTS);
    Card aceSpades = new Card(Rank.ACE, Suit.SPADES);
    System.out.println(kingHearts);
    System.out.println(aceSpades);
  }
}
