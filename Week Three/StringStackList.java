class UnderflowException extends Exception{}
public class StringStackList {
  StringNode topNode;

  public StringStackList() {
    topNode = null;
  }

  public void push(String element) {
    StringNode node = new StringNode(element);
    node.next = topNode;
    topNode = node;
  }

  public String pop() throws UnderflowException{
    if(isEmpty()){
      throw new UnderflowException();
    }
    String popped = topNode.payload;
    topNode = topNode.next;
    return popped;
  }

  public StringNode peek() throws UnderflowException{
    if(isEmpty()){
      throw new UnderflowException();
    }
    return topNode;
  }

  public boolean isEmpty(){
    return topNode == null;
  }

  public int size() throws UnderflowException{
    if(isEmpty()){
      throw new UnderflowException();
    } else {
      return topNode.size();
    }
  }
}
