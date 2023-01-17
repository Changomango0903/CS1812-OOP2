public class Card {
  final private Rank rank;
  final private Suit suit;
  final private int points;

  public Card(Rank rank, Suit suit){
    this.rank = rank;
    this.suit = suit;
    this.points = rank.getPoints();
  }

  public Rank getRank(){ return this.rank;}
  public Suit getSuit(){ return this.suit;}
  public int getPoints(){ return this.points;}

  public boolean equals(Card other){
    if(this.getRank() == other.getRank() && this.getSuit() == other.getSuit()){
      return true;
    } else {
      return false;
    }
  }

  public String toString(){
    return this.rank.name() + " of " + this.getSuit();
  }

}
