import java.util.Random;

public class ReadingListItemStoreTest{
  public static void main(String[] args) {
    //Test no input
    ReadingListItemStore rlis0 = new ReadingListItemStore();
    for(int i = 0; i < 50; i++){
      Random r = new Random();
      char c = (char) (r.nextInt(26) + 'a');
      System.out.println("key " + c);
      String str = "" + c;
      for(int j = 0; j < 10; j++){
        char letter = (char) (r.nextInt(26) + 'a');
        str = str + letter;
      }
      rlis0.put(c + "", str);
    }
    for(int i = 0; i < 100; i++){
      Random r = new Random();
      char c = (char) (r.nextInt(26) + 'a');
      System.out.println("Key: " + c + "\nString: " + rlis0.getRandomItem(c+""));
    }

    //Test ReadingListItemStore
    for(int i = 1; i < 6; i++){
      ReadingListItemStore rlis1 = new ReadingListItemStore("authors.txt", i);
      for(int j = 1; j <= i; j++){
        if(i % j == 0){
          Random r = new Random();
          int num = r.nextInt(20);
          String str = "";
          for(int k = 0; k < num; k++){
            char c = (char)(r.nextInt(26) + 'a');
            str = str + c;
          }
          int m = 0;
          System.out.println(str);
          for(int l = 0; l < str.length(); l = m){
            for(m = i + l; m > l && m <= str.length(); m--){
              if(rlis1.containsKey(str.substring(l, m))){
                System.out.println(rlis1.getRandomItem(str.substring(l, m)));
                break;
              }
            }
          }
        } else {
          continue;
        }
      }
    }
    //Test Bookstore
    
    //Test PrizeWinnerStore

  }
}
