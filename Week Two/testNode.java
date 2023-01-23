public class testNode{
  private static void printNodes(Node n){
    if(n == null){
      System.out.println("");
    } else {
      System.out.print(n.getPayload());
      printNodes(n.getNext());
    }
  }
  public static void main(String[] args) {
    Node third = new Node("!");
    Node second = new Node(" world", third);
    Node first = new Node("Hello", second);
    Node cursor = first;
    while(cursor != null){
      System.out.print(cursor.getPayload());
      cursor = cursor.getNext();
    }
    System.out.println("\n");
    printNodes(first);
  }
}
