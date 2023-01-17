public class Agent {

  private int pos_x;
  private int pos_y;
  private int directionVal; // 0 = north, 1 = east, 2 = south, 3 = west
  private Direction direction = Direction.NORTH;

  public Agent() {
    pos_x = 0; 
    pos_y = 0;
    directionVal = 0;
  }

  void print() {
    System.out.println("The agent is at pos (" + pos_x + "," + pos_y + ")" + 
                          ", facing " + direction);
  }

  void move() {
    switch (direction)
    {
      case NORTH : // north
        pos_y++;
	break;
      case EAST : // east
        pos_x++;
	break;
      case SOUTH : // south
        pos_y--;
	break;
      case WEST : // west
        pos_x--;
	break;
    }
  }

  void turnRight() {
    directionVal = ++directionVal % 4;
    direction = Direction.values()[directionVal]; 

  }

  void turnLeft() {
    turnRight(); turnRight(); turnRight();
  }

  public static void main(String[] args) {
    Agent a = new Agent(); a.print();
    a.turnLeft(); a.move(); a.print();
    a.move(); a.print();
    a.turnRight(); a.turnRight(); a.move(); a.move(); a.print();
    a.turnRight(); a.move(); a.print();
    a.turnLeft(); a.turnLeft(); a.move(); a.print();
  }

}
