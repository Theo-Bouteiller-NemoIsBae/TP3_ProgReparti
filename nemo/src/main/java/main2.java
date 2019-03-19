import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.GregorianCalendar;

public class main2 {
    public static void main(String[] args) {

        int port = 50013;
        int nbClients = 50;
        int nbThread = 2;

//        ServeurTcpEcho serveurTcpEcho = new ServeurTcpEcho(port, nbClients);
//        serveurTcpEcho.run();

//        ServeurTcpEchoMulti serveurTcpEchoMulti = new ServeurTcpEchoMulti(port);
//        serveurTcpEchoMulti.run();

        ServeurTcpEchoPool serveurTcpEchoPool = new ServeurTcpEchoPool(port, nbThread);
        serveurTcpEchoPool.run();
    }
}
