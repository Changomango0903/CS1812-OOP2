import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class HollomonClient{
  String server;
  int port;
  Socket socket;
  InputStream is;
  OutputStream os;
  BufferedReader br;
  CardInputStream cis;
  public HollomonClient(String server, int port) throws IOException{ //Constructor
    this.server = server;
    this.port = port;
    try{
      this.socket = new Socket(server, port);
      is = socket.getInputStream();
      br = new BufferedReader(new InputStreamReader(is));
      os = socket.getOutputStream();
      cis = new CardInputStream(this.is);
      
    } catch(UnknownHostException e){
      e.printStackTrace();
      System.out.println("Error: Cannot connect to host");
    }
  }

  public void writeServer(String str) throws IOException{ //Write to server in one line
    os.write(str.getBytes());
    os.flush();
  }
  public List<Card> getDeck(CardInputStream cis) throws IOException{ //Iterate through deck 
    List<Card> cardList = new ArrayList<Card>();
    Card card = cis.readCard();
    while(card != null){
      cardList.add(card);
      card = cis.readCard();
    }
    Collections.sort(cardList);
    return cardList;
  }

  public List<Card> login(String username, String password) throws IOException{ //Log-in and get Card list
        String credentials = username + "\n" + password + "\n";
        writeServer(credentials);
        String response = br.readLine();
        if(response.equals(String.format("User %s logged in successfully.", username))){
          List<Card> cardList = getDeck(this.cis);
          return cardList;
        } else {
          return null;
        }
  }
  public long getCredits() throws IOException{ //Request for Credit Information
    String requestCredits = "CREDITS\n";
    writeServer(requestCredits);
    String strCredits = br.readLine();
    String response = br.readLine();
    if(response.equals("OK")){
      long longCredits = Long.parseLong(strCredits);
      return longCredits;
    }
    return 0;
  }

  public List<Card> getCards() throws IOException{ //Request more cards
    String requestCards = "CARDS\n";
    writeServer(requestCards);
    List<Card> cardList = getDeck(this.cis);
    return cardList; 
  }

  public List<Card> getOffers() throws IOException{ //request card offers from server
    String requestOffers = "OFFERS\n";
    writeServer(requestOffers);
    List<Card> cardList = getDeck(this.cis);
    return cardList;
  }

  public boolean buyCard(Card card) throws IOException{ //buy card using ID
    String requestBuy = "BUY " + card.getID() + "\n";
    writeServer(requestBuy);
    String response = br.readLine();
    if(response.equals("OK")){
      return true;
    }
    return false;
  }

  public boolean sellCard(Card card, long price) throws IOException{ //Sell card using ID with price
    String requestSell = "SELL " + card.getID() + " " + price + "\n";
    writeServer(requestSell);
    String response = br.readLine();
    if(response.equals("OK")){
      return true;
    }
    return false;
  }

  public void close(){
    try{
      this.is.close();
      this.br.close();
      this.os.close();
      this.socket.close();
      this.cis.close();
    }catch(IOException e){
      System.out.println("No connection has been established");
    }
  }
}