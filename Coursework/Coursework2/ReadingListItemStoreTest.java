public class ReadingListItemStoreTest{
  public static void main(String[] args) {
    ReadingListItemStore store = new ReadingListItemStore();
    store.put("a", "Allen Ginsburg");
    store.put("be", "Ben Jonson");
    store.put("be", "Beryl Bainbridge");
    store.put("a", "Anne Bronte");

    store.getRandomItem("a");
    store.getRandomItem("be");
    store.getRandomItem("c");

    // ReadingListItemStore q2 = new ReadingListItemStore("authors.txt");
    // System.out.println(q2.getRandomItem("a"));
    // System.out.println(q2.getRandomItem("b"));
    // System.out.println(q2.getRandomItem("c"));
  }
}
