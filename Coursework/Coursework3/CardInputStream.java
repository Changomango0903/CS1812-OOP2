import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class CardInputStream extends InputStream{
    BufferedReader input;
    public CardInputStream(Reader input){
        this.input = new BufferedReader(input);
    }

    public Card readCard(){
        try{
            String fLine = input.readLine();
            Long ID = Long.parseLong(input.readLine());
            String name = input.readLine();
            String rankStr = input.readLine();

            Rank rank;
            switch(rankStr){
                case("COMMON"):
                    rank = Rank.COMMON;
                    break;
                case("UNCOMMON"):
                    rank = Rank.UNCOMMON;
                    break;
                case("RARE"):
                    rank = Rank.RARE;
                    break;
                case("UNIQUE"):
                    rank = Rank.UNIQUE;
                    break;
                default:
                    rank = null;
                    break;
            }
            return new Card(ID, name, rank);

        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Outta bounds brotha");
            return null;
        }
        
    }

    @Override
    public int read() throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public void close(){
        try{
            input.close();
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Input stream not opened");
        }
    }
}