import java.io.*;
import java.net.Socket;

public class ThreadServeurEcho extends Thread {
    Socket client;

    public ThreadServeurEcho(Socket client) {
        this.client = client;
    }

    public void start(){
        this.start();
    }

    public void run(){
        try {
            BufferedReader in;
            BufferedWriter out;

            String reponse = "";

            while (!reponse.equals("exit")) {

                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                reponse = in.readLine();

                out.write(reponse.toUpperCase());
                out.newLine();
                out.flush();

            }

        this.client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
