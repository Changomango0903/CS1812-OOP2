class OverflowException extends Exception{}
class StringStackArray{
  String[] array;
  int topIndex;

  public StringStackArray() {
    array = new String[10];
    topIndex = -1;
  }
    
  public void push(String element) throws OverflowException{
    if(topIndex == 9){
      throw new OverflowException();
    }
    topIndex += 1;
    array[topIndex] = element;
  }

  public String pop() throws UnderflowException{
    if(isEmpty()){
      throw new UnderflowException();
    }
    String topElement = array[topIndex];
    topIndex -= 1;
    return topElement;
  }

  public String peek() throws UnderflowException{
    if(isEmpty()){
      throw new UnderflowException();
    }
    return array[topIndex];
  }

  public boolean isEmpty(){
    return topIndex == -1;
  }

  public int size(){
    return topIndex + 1;
  }
}
