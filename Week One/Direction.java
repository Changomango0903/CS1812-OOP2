public enum Direction {
  NORTH(0), EAST(1), SOUTH(2), WEST(3);
  private int numValue;

  private Direction(int numValue){
    this.numValue = numValue;
  }

  public Direction turnAntiClockwise(){
    return Direction.values()[numValue + 1];
  }
}


