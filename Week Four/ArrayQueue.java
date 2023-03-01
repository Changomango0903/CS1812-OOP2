public class ArrayQueue {

  // An array to store the data
  private String[] data;

  private int front = 0;
  private int back = 0;

  public ArrayQueue() { data = new String[10]; }
  public ArrayQueue(int max) {
    if (max <= 0) throw new IllegalArgumentException();
    data = new String[max];
  }

  public void enqueue(String s) throws QueueOverflowException {
    if (back == data.length)
      throw new QueueOverflowException(data.length);
    data[back] = s;
    back = back + 1;
  }

  public String dequeue() throws QueueUnderflowException {
    if (front == back) 
      throw new QueueUnderflowException();
    String s = data[front];
    front = front + 1;
    return s;
  }

  public boolean isEmpty() {
    return (front == back);
  }

  public int size() {
    return back - front;
  }
}

class QueueOverflowException extends Exception {
  private int max_size;
  public QueueOverflowException(int max_size) {
    this.max_size = max_size;
  }
  public String getMessage() {
    return "Queue cannot have more than " + max_size + " elements!";
  }
}

class QueueUnderflowException extends Exception {}