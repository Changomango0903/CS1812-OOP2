class TestQueue{
  public static void main(String[] args) {
    MyQueue qInt = new MyQueue();

    qInt.enqueue(42);
    qInt.enqueue(3);
    System.out.println(qInt);

    System.out.println(qInt.dequeue());

    System.out.println(qInt.size());

  }
}
