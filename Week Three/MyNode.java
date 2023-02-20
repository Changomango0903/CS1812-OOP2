public class MyNode{
  MyNode next, previous;
  int payload;
  public MyNode(int payload){
    this.payload = payload;
  }

  public MyNode(int payload, MyNode next, MyNode previous){
    this.payload = payload;
    this.next = next;
    this.previous = previous;
  }
}
