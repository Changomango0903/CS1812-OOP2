public class Node{
  private String s;
  private Node next = null;

  public Node(String s, Node next){
    this.s = s;
    this.next = next;
  }

  public Node(String s){
    this.s = s;
  }

  public String getPayload(){return this.s;}
  public Node getNext(){return this.next;}

  public void setPayload(String s){
    this.s = s;
  }
  public void setNext(Node next){
    this.next = next;
  }
}
