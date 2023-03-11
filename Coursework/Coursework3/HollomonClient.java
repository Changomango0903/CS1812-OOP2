import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
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
    try(BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
      try(OutputStream os = socket.getOutputStream()){
        String fUsername = username + "\n";
        String fPassword = password + "\n";
        os.write(fUsername.getBytes());
        os.write(fPassword.getBytes());
        os.flush();
        String response = br.readLine();
        System.out.println(response);
        if(response.equalsIgnoreCase("Incorrect password.")){
          return null;
        } else {
          return new ArrayList<Card>();
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
      socket.close();
    }catch(IOException e){
      System.out.println("No connection has been established");
    }
  }
}