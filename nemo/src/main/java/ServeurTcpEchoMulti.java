import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTcpEchoMulti {
    int port;

    public ServeurTcpEchoMulti(int port) {
        this.port = port;
    }

    public void run(){
        try {
            ServerSocket serveur  = new ServerSocket(this.port);

            while(true) {
                new ThreadServeurEcho(serveur.accept());
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
