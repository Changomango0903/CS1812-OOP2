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
  //Searches and shrinks prefix until a match is found
  public List<String> generate(String input, int num){
    input = input.toLowerCase();
    int gap = num;
    int length = input.length();
    List<String> result = new ArrayList<String>(); 
    int j = num;
    for(int i = 0; i<length; i=j){
      for(j = i + num; j > i && j <= input.length() + 1; j--){
        if(i % 3 == 1){
          if(PWS.containsKey(input.substring(i, j))){
            result.add(PWS.getRandomItem(input.substring(i, j)));
            break;
          } else {
            continue;
          }
        } else if(i % 3 == 2){
          if(BS.containsKey(input.substring(i, j))){
            result.add(BS.getRandomItem(input.substring(i, j)));
            break;
          } else {
            continue;
          }
        } else{
          if(RLIS.containsKey(input.substring(i, j))){
            result.add(RLIS.getRandomItem(input.substring(i, j)));
            break;
          } else {
            continue;
          }
        }
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
