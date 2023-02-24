import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
public class PrizeWinnerStore extends ReadingListItemStore{
  Map<String, List<String>> map;
  public PrizeWinnerStore(){
    map = new HashMap<String, List<String>>();
  }
  public PrizeWinnerStore(String fileName, int num){
    map = new HashMap<String, List<String>>();
    try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
      String line = br.readLine();
      while(line != null){
        for(int i = 1; i <= num; i++){
          line = line.toLowerCase();
          line = line.substring(0, i).toUpperCase() + line.substring(1);
          this.put(line.substring(0, i).toLowerCase(), line);
        }
        line = br.readLine();
        // line = line.toLowerCase();
        // line = line.substring(0, 1).toUpperCase() + line.substring(1);
        // // System.out.println(line);
        // // System.out.println(line.substring(0, 1));
        // this.put(line.substring(0, 1).toLowerCase(), line);
        // line = br.readLine();
      }
    } catch (IOException e){
      e.printStackTrace();
      System.out.println("Error : File cannot be found");
    }
  }

  public PrizeWinnerStore(String fileName){
    map = new HashMap<String, List<String>>();
    try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
      String line = br.readLine();
      while(line != null){
        line = line.toLowerCase();
        line = line.substring(0, 1).toUpperCase() + line.substring(1);
        // System.out.println(line);
        // System.out.println(line.substring(0, 1));
        this.put(line.substring(0, 1).toLowerCase(), line);
        line = br.readLine();
      }
    } catch (IOException e){
      e.printStackTrace();
      System.out.println("Error : File cannot be found");
    }
  }

  public boolean containsKey(String key){
    return map.containsKey(key.toLowerCase());
  }

  public void put(String key, String item){
    if(containsKey(key)){
      List<String> list = map.get(key.toLowerCase());
      String formatItem = item.substring(0,1).toUpperCase() + item.substring(1);
      list.add(formatItem);
      map.put(key, list);
    } else {
      List<String> list = new ArrayList<String>();
      String formatItem = item.substring(0,1).toUpperCase() + item.substring(1);
      list.add(formatItem);
      map.put(key, list);
    }
  }

  @Override
  public String getRandomItem(String key){
    if(containsKey(key)){
      Random randNum = new Random();
      List<String> list = map.get(key.toLowerCase());
      return list.get(randNum.nextInt(list.size())) + " (prize-winner)";
    } else {
      return null;
    }
  }

}
