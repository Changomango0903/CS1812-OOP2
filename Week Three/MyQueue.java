public class MyQueue{
  MyNode front, back;
  public void enqueue(int payload){
    if(front == null && back == null){
      front = new MyNode(payload);
      back = front;
    } else{
      MyNode last = new MyNode(payload, null, back);
      back.next = last;
      back = last;
    }
  }

  public int dequeue(){
    int prevFront = front.payload;
    front = front.next;
    return prevFront;
  }

  public boolean isEmpty(){
    return front == null;
  }

  public int size(){
    if(isEmpty()){
      return 0;
    }
    int length = 0;
    for(MyNode cursor = front;cursor != null; cursor = cursor.next){
      length++;
    }
    return length;
  }

}
