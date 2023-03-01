import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lorem{
  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("./loremIpsum.txt"));
    HashSet<String> hSet = new HashSet<String>();
    do{
      String word = scanner.next();
      System.out.println(hSet.contains(word));
      hSet.add(word);
    }while(scanner.hasNext()); 
    scanner.close();

    Scanner scanner2 = new Scanner(new File("./loremIpsum.txt"));
    HashMap<String, Integer> hMap = new HashMap<String, Integer>();
    do{
      String word = scanner2.next();
      if(hMap.containsKey(word)){
        hMap.put(word, hMap.get(word) + 1);
      } else {
        hMap.put(word, 1);
      }
    }while(scanner2.hasNext());
    Set<String> keys = hMap.keySet();
    String highest = "";
    for(String key : keys){

      System.out.println(key + " : " + hMap.get(key));
    }
  }
}
