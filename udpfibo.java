// UDPFibonacciServer.java
import java.net.*;

public class UDPFibonacciServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);

        int n = Integer.parseInt(new String(dp.getData(), 0, dp.getLength()));
        StringBuilder sb = new StringBuilder();
        int a = 0, b = 1;
        while (a <= n) {
            sb.append(a).append(" ");
            int next = a + b;
            a = b; b = next;
        }

        byte[] send = sb.toString().trim().getBytes();
        ds.send(new DatagramPacket(send, send.length, dp.getAddress(), dp.getPort()));
        ds.close();
    }
}

// UDPFibonacciClient.java
import java.net.*;
import java.util.Scanner;

public class UDPFibonacciClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter range: ");
        int n = sc.nextInt();

        byte[] send = String.valueOf(n).getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        ds.send(new DatagramPacket(send, send.length, ip, 5000));

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);
        System.out.println("Fibonacci: " + new String(dp.getData(), 0, dp.getLength()));
        ds.close(); sc.close();
    }
}
