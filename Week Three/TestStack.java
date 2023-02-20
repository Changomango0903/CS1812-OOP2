public class TestStack{
  public static void main(String[] args) {
    StringStackArray myStack = new StringStackArray();
    try{
      myStack.push("!");
      myStack.push("world");
      myStack.push("Hello");

      System.out.println(myStack.size());

      System.out.println(myStack.pop());
      System.out.println(myStack.pop());
      System.out.println(myStack.pop());
      while(true){
        myStack.push("ouch");
      }
    } catch (OverflowException e){
        e.printStackTrace();
        System.out.println("lol");
    } catch (UnderflowException e){
        e.printStackTrace();
        System.out.println("lol");
    }
  }
}
