public enum Rank {
  ACE(20, "ace"), KING(15, "face"), QUEEN(15, "face"), JACK(15, "face"), TEN(10, "number"), NINE(9, "number"), EIGHT(8, "number"), SEVEN(7, "number"), SIX(6, "number"), FIVE(5, "number"), FOUR(4, "number"), THREE(3, "number"), TWO(2, "number"); 

  private int points;
  private String face;

  private Rank(int points, String faces) {
    this.points = points;
    this.face = faces;
  }
  
  public int getPoints() {
    return this.points;
  }

  public String toString(){
    return this.name() + " (" + this.face + ")" + ": " + this.getPoints();
  }
}
