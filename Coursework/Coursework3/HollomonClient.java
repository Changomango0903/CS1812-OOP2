import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class HollomonClient{
  String server;
  int port;
  Socket socket;
  InputStream is;
  OutputStream os;
  public HollomonClient(String server, int port){
    this.server = server;
    this.port = port;
    try{
      this.socket = new Socket(server, port);
      is = socket.getInputStream();
      os = socket.getOutputStream();
    } catch(Exception e){
      e.printStackTrace();
      System.out.println("Error: Cannot connect to host");
    }
  }
  public List<Card> login(String username, String password){
    try(BufferedReader br = new BufferedReader(new InputStreamReader(this.is))){
      try(OutputStream os = this.os){
        String fUsername = username + "\n";
        String fPassword = password + "\n";
        os.write(fUsername.getBytes());
        os.write(fPassword.getBytes());
        os.flush();
        String response = br.readLine();
        System.out.println(response);
        if(response.equals(String.format("User %s logged in successfully.", username))){
          List<Card> cardList = new ArrayList<Card>();
          CardInputStream cis = new CardInputStream(this.is);
          Card currCard = cis.readCard();
          while(currCard != null){
            cardList.add(currCard);
            currCard = cis.readCard();
          }
          //Collections.sort(cardList);
          return cardList;

        } else {
          return null;
        }
      } catch(IOException e){
        e.printStackTrace();
        System.out.println("Output Stream could not be established");
        return null;
      }
    } catch(IOException e){
      e.printStackTrace();
      System.out.println("Input Stream could not be established");
      return null;
    }
  }

  public void close(){
    try{
      this.is.close();
      this.os.close();
      this.socket.close();
    }catch(IOException e){
      System.out.println("No connection has been established");
    }
  }
}