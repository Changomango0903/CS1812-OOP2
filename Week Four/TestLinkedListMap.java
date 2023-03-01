public class TestLinkedListMap{
  public static void main(String[] args) {
    LinkedListMap<String, Integer> mSI = new LinkedListMap<String, Integer>();
    mSI.put("Hello", 42);
    mSI.put("World", 7);

    System.out.println(mSI.get("Hello"));
    mSI.put("World", 12);
    System.out.println(mSI.get("World"));
    System.out.println(mSI.containsValue(7));
    System.out.println(mSI);
  }
}
