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