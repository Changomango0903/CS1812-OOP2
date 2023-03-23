import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HollomonClientTest{
    public static void main(String[] args) {
        try{
            HollomonClient hc0 = new HollomonClient("netsrv.cim.rhul.ac.uk", 1812);
            List<Card> cardList = hc0.login("bottest", "testpass");
            List<Card> cardTest = new ArrayList<Card>();
            cardTest.add(new Card(2, "test1", Rank.COMMON));
            cardTest.add(new Card(1, "test2", Rank.UNIQUE));
            cardTest.add(new Card(3, "atest", Rank.COMMON));
            Collections.sort(cardTest);
            for(int i = 0; i < cardList.size(); i++){
                System.out.println(cardList.get(i));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        

    }
}