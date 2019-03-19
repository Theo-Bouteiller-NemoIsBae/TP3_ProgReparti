import java.io.*;
import java.net.Socket;

public class ThreadServeurEcho extends Thread {
    Socket client;

    public ThreadServeurEcho(Socket client) {
        this.client = client;
        this.start();
    }

    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String reponse = "";

            reponse = in.readLine();
            while (!reponse.equals("exit")) {
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
