// UDPCountDigitsServer.java
import java.net.*;

public class UDPCountDigitsServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);

        String num = new String(dp.getData(), 0, dp.getLength());
        int count = num.replaceAll("-", "").length();
        byte[] send = String.valueOf(count).getBytes();
        ds.send(new DatagramPacket(send, send.length, dp.getAddress(), dp.getPort()));
        ds.close();
    }
}

// UDPCountDigitsClient.java
import java.net.*;
import java.util.Scanner;

public class UDPCountDigitsClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        byte[] send = String.valueOf(n).getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        ds.send(new DatagramPacket(send, send.length, ip, 5000));

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);
        System.out.println("Number of digits = " + new String(dp.getData(), 0, dp.getLength()));
        ds.close(); sc.close();
    }
}
