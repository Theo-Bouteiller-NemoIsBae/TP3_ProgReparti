import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main (String[] args) {
        System.out.println("Hello World");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("ip :");
            String ip = br.readLine();
            System.out.println("port :");
            int port = Integer.parseInt(br.readLine());

            //ClientTcpEcho clientTcpEcho = new ClientTcpEcho(ip, port);
            ClientTcpEcho clientTcpEcho = new ClientTcpEcho("10.203.9.145", 50007);
            clientTcpEcho.lancerBW();


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
