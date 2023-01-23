public class testStringList{
  public static void main(String[] args) {
    stringLinkedList list = new stringLinkedList();
    for(String s: args){
      list.append(s);
    }
    list.append("Last");
    System.out.println(list);
  }
}
