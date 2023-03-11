import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
public class HollomonClient{
  String server;
  int port;
  Socket socket;
  public HollomonClient(String server, int port){
    this.server = server;
    this.port = port;
    try{
      this.socket = new Socket(server, port);
    } catch(Exception e){
      e.printStackTrace();
      System.out.println("Error: Cannot connect to host");
    }
  }
  public List<Card> login(String username, String password){
    try(InputStream is = socket.getInputStream()){
      try(OutputStream os = socket.getOutputStream()){
        DataOutputStream dos = new DataOutputStream(os);
        String fUsername = username + "\n";
        String fPassword = password + "\n";
        os.write(fUsername.getBytes());
        os.flush();
        os.write(fPassword.getBytes());
        os.flush();
        return new ArrayList<Card>();
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
      socket.close();
    }catch(IOException e){
      System.out.println("No connection has been established");
    }
  }
}