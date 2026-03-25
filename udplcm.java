// UDPLCMServer.java
import java.net.*;

public class UDPLCMServer {
    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);

        String[] nums = new String(dp.getData(), 0, dp.getLength()).split(",");
        int a = Integer.parseInt(nums[0]), b = Integer.parseInt(nums[1]);
        int lcm = (a * b) / gcd(a, b);

        byte[] send = String.valueOf(lcm).getBytes();
        ds.send(new DatagramPacket(send, send.length, dp.getAddress(), dp.getPort()));
        ds.close();
    }
}

// UDPLCMClient.java
import java.net.*;
import java.util.Scanner;

public class UDPLCMClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt(), b = sc.nextInt();

        byte[] send = (a + "," + b).getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        ds.send(new DatagramPacket(send, send.length, ip, 5000));

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);
        System.out.println("LCM = " + new String(dp.getData(), 0, dp.getLength()));
        ds.close(); sc.close();
    }
}
