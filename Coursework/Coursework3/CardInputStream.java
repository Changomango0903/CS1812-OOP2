import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class CardInputStream extends InputStream{
    BufferedReader input;
    public CardInputStream(InputStream input){
        this.input = new BufferedReader(new InputStreamReader(input));
    }

    public Card readCard() throws IOException{
        String logicLine = input.readLine();
        Long ID = Long.parseLong(input.readLine());
        String name = input.readLine();
        String rankStr = input.readLine();
        String price = input.readLine();

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
    }

    public String readResponse() throws IOException{
        return input.readLine();
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