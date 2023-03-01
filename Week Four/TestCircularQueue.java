public class TestCircularQueue{
  public static void main(String[] args) {
    try{
      CircularArrayQueue circleQueue = new CircularArrayQueue(9);
      for(int i = 0; i < circleQueue.size(); i++){
        circleQueue.enqueue(i+"");
      }
      circleQueue.dequeue();
      circleQueue.dequeue();
      System.out.println(circleQueue.size());
      circleQueue.enqueue("10");
      circleQueue.enqueue("11");
    } catch(Exception e){
      e.printStackTrace();
    }
  }
}
