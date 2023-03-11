import java.util.List;

public class CardTest{
  public static void main(String[] args) {
    Card c1 = new Card(32178937, "c1", Rank.UNIQUE);
    Card c2 = new Card(45738294, "c2", Rank.RARE);
    Card c3 = new Card(32178937, "c1", Rank.UNIQUE);
    Card c4 = new Card(32178937, "c1", Rank.RARE);
    Card c5 = new Card(32178937, "c3", Rank.UNIQUE);
    Card[] testDeck = {c2, c3, c4, c5};
    for(int i = 0; i < 4; i++){
      System.out.println("c1 vs " + "c" + i);
      System.out.println(c1.equals(testDeck[i]));
      System.out.println(c1.compareTo(testDeck[i]));
    }
  }
}
