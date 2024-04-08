import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    
    public void run() throws IOException, UnknownHostException{
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(20000);// will wait for this time , then it will get closed 
        while(true){
            System.out.println("Server is listening on port: "+port);
            Socket acceptedConnection = socket.accept();// code waits here till i get some connection from client side, will get closed within 20 secs though 
            System.out.println("Connected accepted from client "+acceptedConnection.getRemoteSocketAddress());// so we are connected now 
            PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);// getOutput Stream gives us the output stream
            // we can write something in the output stream with PrintWriter
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));// buffer needs reader so we are using input stream reader 
            // buffer reader is used in input stream as it gives results by combining the input coming through inputStream
            // printWriter does the conversion of whatever i write to bytes in input stream
            toClient.println("Hello World from the server");// sending it to Client
            toClient.close();
            fromClient.close();
            acceptedConnection.close();
        }
    }

    public static void main(String[] args){// its a static method not present on memeory , so have to make an instance 
        Server server = new Server();
        try{
            server.run();
        }catch(Exception ex){
            ex.printStackTrace();// stack trace prints everything before the exception
        }
    }

}
