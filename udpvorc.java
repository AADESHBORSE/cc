// UDPVowelServer.java
import java.net.*;

public class UDPVowelServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);

        char c = Character.toLowerCase(new String(dp.getData(), 0, dp.getLength()).charAt(0));
        String result = "aeiou".indexOf(c) != -1 ? "Vowel" : "Consonant";
        byte[] send = result.getBytes();
        ds.send(new DatagramPacket(send, send.length, dp.getAddress(), dp.getPort()));
        ds.close();
    }
}

// UDPVowelClient.java
import java.net.*;
import java.util.Scanner;

public class UDPVowelClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char c = sc.next().charAt(0);

        byte[] send = String.valueOf(c).getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        ds.send(new DatagramPacket(send, send.length, ip, 5000));

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);
        System.out.println(new String(dp.getData(), 0, dp.getLength()));
        ds.close(); sc.close();
    }
}
