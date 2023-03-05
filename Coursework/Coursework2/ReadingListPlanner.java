import java.util.ArrayList;
import java.util.List;
public class ReadingListPlanner{
  public ReadingListItemStore RLIS;
  public PrizeWinnerStore PWS;
  public BookStore BS;
  public ReadingListPlanner(String RLIS, String PWS, String BS){
    this.RLIS = new ReadingListItemStore(RLIS, 1);
    this.PWS = new PrizeWinnerStore(PWS, 1);
    this.BS = new BookStore(BS, 1);
  }
  public ReadingListPlanner(String RLIS, String PWS, String BS, int prefLeng){
    this.RLIS = new ReadingListItemStore(RLIS, prefLeng);
    this.PWS  = new PrizeWinnerStore(PWS, prefLeng);
    this.BS = new BookStore(BS, prefLeng);
  }

  //Method if prefix length not specified
  public List<String> generate(String input){ return generate(input, 1);}

  //Method if length specified
  public List<String> generate(String input, int num){
    input = input.toLowerCase();
    int gap = num;
    int length = input.length();
    int pos = 0;
    List<String> result = new ArrayList<String>();
    if(length >= 1){
      result.add(RLIS.getRandomItem(input.substring(pos, pos+gap)));
      pos+=gap;
    }
    if(length >= 2){
      result.add(PWS.getRandomItem(input.substring(pos, pos+gap)));
      pos+=gap;
    }
    if(length >= 3){
      result.add(BS.getRandomItem(input.substring(pos, pos+gap)));
      pos+=gap;
    }
    for(int i = pos; i<length;i+=gap){
      if(i/gap<(length-pos)/2){
        result.add(BS.getRandomItem(input.substring(i, i+gap)));
      } else {
        result.add(PWS.getRandomItem(input.substring(i,i+gap)));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> plan;
    if(args.length > 1){
      ReadingListPlanner planner = new ReadingListPlanner("authors.txt", "prize-winners.txt", "books.txt", Integer.parseInt(args[1]));
      plan = planner.generate(args[0], Integer.parseInt(args[1]));
    
    } else {
      ReadingListPlanner planner = new ReadingListPlanner("authors.txt", "prize-winners.txt", "books.txt");
      plan = planner.generate(args[0]);
    }
    for(String item : plan){
      System.out.println(item);
    } 
  }
}
