public class CircularArrayQueue{
  // An array to store the data
  private String[] data;

  private int front = 0;
  private int back = 0;
  private boolean empty = true;

  public CircularArrayQueue() { data = new String[10]; }
  public CircularArrayQueue(int max) {
    if (max <= 0) throw new IllegalArgumentException();
    data = new String[max];
  }

  public void enqueue(String s) throws QueueOverflowException {
    if (back == data.length){
      back = 0;
    } else if(back == front && !empty){
      throw new QueueOverflowException(data.length);
    }
    empty = false;
    data[back] = s;
    back = back + 1;
  }

  public String dequeue() throws QueueUnderflowException {
    if(front == data.length){
      front = 0;
    }
    if (front == back && empty){ 
      throw new QueueUnderflowException();
    }
    String s = data[front];
    front = front + 1;
    return s;
  }

  public boolean isEmpty() {
    return empty;
  }

  public int size() {
    int size = 0;
    for(String item : data){
      if (item != null){
        size++;
      }
    }
    return size;
  }
}


