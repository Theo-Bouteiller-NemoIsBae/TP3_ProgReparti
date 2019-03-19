import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTcpEcho {
    int port;
    int nbClients;

    public ServeurTcpEcho(int port, int nbClient) {
        this.port = port;
        this.nbClients = nbClient;
    }

    public void run(){
        Socket client;
        BufferedWriter out;
        BufferedReader in;

        try {
            ServerSocket serveur  = new ServerSocket(this.port);

            for (int i = 1; i <= this.nbClients; i++) {
                client = serveur.accept();

                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                String reponse = "";

                while (!reponse.equals("exit")) {
                    reponse = in.readLine();
                    out.write(reponse.toUpperCase());
                    out.newLine();
                    out.flush();
                }

                client.close();
            }


            serveur.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
