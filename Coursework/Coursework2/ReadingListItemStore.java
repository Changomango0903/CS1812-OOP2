import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
public class ReadingListItemStore{
  private Map<String, List<String>> map; //Hashmap for holding keys & objects

  //Constructor Graveyard
  //Initialize basic map
  public ReadingListItemStore(){ map = new HashMap<String, List<String>>();}
  //Maps keys based on prefix length
  public ReadingListItemStore(String fileName, int prefixLength){
    map = new HashMap<String, List<String>>();
    try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
      String line = br.readLine();
      while(line != null){
        for(int i = 1; i <= prefixLength; i++){
          line = line.substring(0, i).toUpperCase() + line.substring(i);
          this.put(line.substring(0, i).toLowerCase(), line);
        }
        line = br.readLine();
      }
    } catch (IOException e){
      e.printStackTrace();
      System.out.println("Error : File cannot be found");
    }
  }
  //Maps keys based on first letter
  public ReadingListItemStore(String fileName){
    map = new HashMap<String, List<String>>();
    try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
      String line = br.readLine();
      while(line != null){
        line = line.substring(0, 1).toUpperCase() + line.substring(1);
        this.put(line.substring(0, 1).toLowerCase(), line);
        line = br.readLine();
      }
    } catch (IOException e){
      e.printStackTrace();
      System.out.println("Error : File cannot be found");
    }
  }

  //Returns whether key exists in map
  public boolean containsKey(String key){
    return map.containsKey(key.toLowerCase());
  }

  //Creates list object and adds string item into key location
  //if list objects already exists, inserts item to end of list
  public void put(String key, String item){
    if(containsKey(key)){
      List<String> list = map.get(key.toLowerCase());
      list.add(item.substring(0, 1).toUpperCase() + item.substring(1));
      map.put(key, list);
    } else {
      List<String> list = new ArrayList<String>();
      list.add(item.substring(0, 1).toUpperCase() + item.substring(1));
      map.put(key, list);
    }
  }
  //Gets random item from key location
  public String getRandomItem(String key){
    if(containsKey(key)){
      Random randNum = new Random();
      List<String> list = map.get(key.toLowerCase());
      return list.get(randNum.nextInt(list.size()));
    } else {
      return null;
    }
  }
}
