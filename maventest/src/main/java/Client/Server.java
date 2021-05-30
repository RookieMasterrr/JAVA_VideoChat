package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerSocket{
    public Server(int P)throws IOException{
        super(P);
    }
    static public String Read(Socket aSocket)throws IOException{
        byte a[] = new byte[65536];
        InputStream aInputStream = aSocket.getInputStream();
        aInputStream.read(a);
        return (new String(a));
    }
    static public void Write(Socket aSocket,String text) throws IOException{
        OutputStream aOutputStream = aSocket.getOutputStream();
        byte aText[] = new byte[65535];
        aText = text.getBytes();
        aOutputStream.write(aText);
    }
    static public void UpdateList(Socket aSocket,String text) throws IOException{
        OutputStream aOutputStream = aSocket.getOutputStream();
        byte aText[] = text.getBytes();
        aOutputStream.write(aText);        
    }
//    public static void main(String[] args) throws IOException{
//        Server aServer = new Server(5050);    
//        Socket serverSide = aServer.accept();    
//
//        while(true){
//            System.out.println(Read(serverSide));
//            Write(serverSide, "ServerEcho");
//            System.out.println(Read(serverSide));
//            Write(serverSide, "ServerEcho");
//        }
//    }
}
