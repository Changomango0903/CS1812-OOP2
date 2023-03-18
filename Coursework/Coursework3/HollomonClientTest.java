import java.util.List;

public class HollomonClientTest{
    public static void main(String[] args) {
        HollomonClient hc0 = new HollomonClient("netsrv.cim.rhul.ac.uk", 1812);
        List<Card> cardList = hc0.login("bottest", "testpass");
        Card[] cardTest = {new Card(2, "test1", Rank.COMMON), new Card(1, "test2", Rank.UNIQUE), new Card(3, "atest", Rank.COMMON)};

        for(int i = 0; i < cardList.size(); i++){
            System.out.println(cardList.get(i));
        }

    }
}