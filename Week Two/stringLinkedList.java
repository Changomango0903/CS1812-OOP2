public class stringLinkedList{
  private Node head;

  public stringLinkedList(){
    head = null;
  }
  public stringLinkedList(String s){
    head = new Node(s);
  }

  public boolean isEmpty(){
    if(head == null){
      return true;
    } else {
      return false;
    }
  }

  public void append(String s){
    if(isEmpty()){
      head = new Node(s);
    } else {
      head = new Node(s, head);
    }
  }

  public void insterHead(String s){
    head = new Node(s, head);
  }

  public Node getHead(){
    return head;
  }

  public void removeHead(){
    head = head.getNext();
  }

  public boolean find(String s){
    for(Node cursor = head; cursor != null; cursor = cursor.getNext()){
      if(cursor.getPayload().equals(s)){
        return true;
      }
    }
    return false;
  }

  public String toString(){
    Node cursor = head;
    String returnString = "";
    while(cursor != null){
      returnString += cursor.getPayload();     
      cursor = cursor.getNext();
    }
    return returnString;
  }
}
