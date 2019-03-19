import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServeurTcpEchoPool {
    int port;
    int nbThread;

    public ServeurTcpEchoPool(int port, int nbThread) {
        this.port = port;
        this.nbThread = nbThread;
    }

    public void run(){
        try {
            ExecutorService pool= Executors.newFixedThreadPool(nbThread);
            ServerSocket serveur  = new ServerSocket(this.port);

            while(true) {
                pool.execute(new ThreadServeurEcho(serveur.accept()));
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
