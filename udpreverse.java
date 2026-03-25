// UDPReverseServer.java
import java.net.*;

public class UDPReverseServer {
    static int reverse(int n, int rev) {
        if (n == 0) return rev;
        return reverse(n / 10, rev * 10 + n % 10);
    }

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] receive = new byte[1024];

        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);

        int n = Integer.parseInt(new String(dp.getData(), 0, dp.getLength()));
        String result = String.valueOf(reverse(n, 0));
        byte[] send = result.getBytes();

        ds.send(new DatagramPacket(send, send.length, dp.getAddress(), dp.getPort()));
        ds.close();
    }
}

// UDPReverseClient.java
import java.net.*;
import java.util.Scanner;

public class UDPReverseClient {
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

        System.out.println("Reversed = " + new String(dp.getData(), 0, dp.getLength()));
        ds.close(); sc.close();
    }
}
