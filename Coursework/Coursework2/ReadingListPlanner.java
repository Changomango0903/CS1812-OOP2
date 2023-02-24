import java.util.ArrayList;
import java.util.List;
public class ReadingListPlanner{
  public static ReadingListItemStore RLIS;
  public static PrizeWinnerStore PWS;
  public static BookStore BS;
  public static List<String> generate(String input){
    input = input.toLowerCase();
    char[] cArray = input.toCharArray();
    int length = cArray.length;
    int pos = 0;
    List<String> result = new ArrayList<String>();
    if(length >= 1){
      result.add(RLIS.getRandomItem(cArray[pos]+""));
      pos++;
    }
    if(length >= 2){
      result.add(PWS.getRandomItem(cArray[pos]+""));
      pos++;
    }
    if(length >= 3){
      result.add(BS.getRandomItem(cArray[pos]+""));
      pos++;
    }
    for(int i = 0; i<length-pos;i++){
      if(i<(length-pos)/2){
        result.add(BS.getRandomItem(cArray[i+pos]+""));
      } else {
        result.add(PWS.getRandomItem(cArray[i+pos]+""));
      }
    }

    return result;
  }


  public static List<String> generate(String input, int num){
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
      RLIS = new ReadingListItemStore("authors.txt", Integer.parseInt(args[1]));
      PWS = new PrizeWinnerStore("prize-winners.txt", Integer.parseInt(args[1]));
      BS = new BookStore("books.txt", Integer.parseInt(args[1]));
      plan = generate(args[0], Integer.parseInt(args[1]));
    
    } else {
      RLIS = new ReadingListItemStore("authors.txt");
      PWS = new PrizeWinnerStore("prize-winners.txt");
      BS = new BookStore("books.txt");
      plan = generate(args[0]);
    }
    for(String item : plan){
      System.out.println(item);
    }
    
  }
}
