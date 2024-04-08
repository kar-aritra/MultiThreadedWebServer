import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    
    public void run() throws UnknownHostException, IOException{// catching errors from unknown host
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");// running the server in local address 
        Socket socket = new Socket(address, port);// this fuction is checked by IOException
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("Hello  from the client "+socket.getLocalSocketAddress());
        String line = fromSocket.readLine();// reading responses coming from the socket
        System.out.println("Response from the socket is:"+line);
        toSocket.close();
        fromSocket.close();
        socket.close();
    }
    
    public static void main(String[] args) {
        Client singleThreadedWebServer_Client = new Client();
        try{
            singleThreadedWebServer_Client.run();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
