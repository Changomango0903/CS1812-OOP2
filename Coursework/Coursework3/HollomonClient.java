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
  BufferedReader br;
  OutputStream os;
  CardInputStream cis;
  public HollomonClient(String server, int port){
    this.server = server;
    this.port = port;
    try{
      this.socket = new Socket(server, port);
      is = socket.getInputStream();
      br = new BufferedReader(new InputStreamReader(is));
      os = socket.getOutputStream();
      cis = new CardInputStream(this.is);
      
    } catch(Exception e){
      e.printStackTrace();
      System.out.println("Error: Cannot connect to host");
    }
  }
  public List<Card> login(String username, String password) throws IOException{
        String fUsername = username + "\n";
        String fPassword = password + "\n";
        os.write(fUsername.getBytes());
        os.write(fPassword.getBytes());
        os.flush();
        String response = br.readLine();
        System.out.println(response);
        if(response.equals(String.format("User %s logged in successfully.", username))){
          List<Card> cardList = new ArrayList<Card>();
          Card currCard = cis.readCard();
          while(currCard != null){
            cardList.add(currCard);
            currCard = cis.readCard();
          }
          Collections.sort(cardList);
          return cardList;

        } else {
          return null;
        }
  }
  public long getCredits() throws IOException{
    String requestCredits = "CREDITS\n";
    os.write(requestCredits.getBytes());
    os.flush();
    String strCredits = br.readLine();
    String response = br.readLine();
    long longCredits = Long.parseLong(strCredits);
    return longCredits;
  }

  public List<Card> getCards() throws IOException{
    String requestCards = "CARDS\n";
    os.write(requestCards.getBytes());
    os.flush();
    List<Card> cardList = new ArrayList<Card>();
    Card currCard = cis.readCard();
    while(currCard != null){
      cardList.add(currCard);
      currCard = cis.readCard();
    }
    Collections.sort(cardList);
    return cardList; 
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