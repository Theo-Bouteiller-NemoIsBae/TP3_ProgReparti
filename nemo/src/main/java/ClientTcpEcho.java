import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTcpEcho {
    String hostName;
    int port;

    ClientTcpEcho(String hostName, int port){
        this.hostName = hostName;
        this.port = port;
    }

    public void lancerBW(){
        Socket socketClient = new Socket();
        try {
            System.out.println("creation socket");
            socketClient.connect(new InetSocketAddress(this.hostName, this.port));

            BufferedReader brIn = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter brWriter = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            BufferedReader brOut = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

            String ligne = "";

            while (!ligne.equals("exit")) {

                System.out.println("Entrée une ligne:");
                ligne = brIn.readLine();

                brWriter.write(ligne);
                brWriter.newLine();
                brWriter.flush();

                String reponse = brOut.readLine();
                System.out.println(reponse);

            }

            System.out.println("fermeture client");

            brWriter.close();
            brOut.close();
            brIn.close();
            socketClient.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
