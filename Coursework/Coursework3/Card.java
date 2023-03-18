public class Card implements Comparable<Card>{
  private long id;
  private String name;
  private Rank rank;
  private int price;

  public Card(long id, String name, Rank rank){
    this.id = id;
    this.name = name;
    this.rank = rank;
    this.price = 0;
  }

  public long getID(){return this.id;}
  public String getName(){return this.name;}
  public Rank getRank(){return this.rank;}
  public int getPrice(){return this.price;}
  public String toString(){return "ID: " + this.id + "\nNAME: " + this.name + "\nRANK: " + this.rank + "\nPrice: " + this.price;}

  public int hashCode(){return java.util.Objects.hashCode(id);}
  public boolean equals(Object obj){
    if(obj == null || obj.getClass() != this.getClass()){
      return false;
    } else {
      Card card = (Card) obj;
      return this.getName().equals(card.getName()) && this.getRank().equals(card.getRank()) && Long.compare(this.getID(), card.getID()) == 0;
    }
  }

  public int compareTo(Card card){
    if(this.equals(card)){
      return 0;
    } else if(this.getRank() != card.getRank()){
      return this.getRank().compareTo(card.getRank());
    } else if(this.getName().compareTo(card.getName()) != 0){
      return this.getName().compareTo(card.getName());
    } else if(this.getID() != card.getID()){
      return Long.compare(this.getID(), card.getID());
    }
    return 1;
  }
}
