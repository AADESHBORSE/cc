// UDPSumListServer.java
import java.net.*;

public class UDPSumListServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);

        String[] nums = new String(dp.getData(), 0, dp.getLength()).split(",");
        int sum = 0;
        for (String num : nums) sum += Integer.parseInt(num.trim());

        byte[] send = String.valueOf(sum).getBytes();
        ds.send(new DatagramPacket(send, send.length, dp.getAddress(), dp.getPort()));
        ds.close();
    }
}

// UDPSumListClient.java
import java.net.*;
import java.util.Scanner;

public class UDPSumListClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numbers separated by comma: ");
        String data = sc.nextLine();

        byte[] send = data.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        ds.send(new DatagramPacket(send, send.length, ip, 5000));

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);
        System.out.println("Sum = " + new String(dp.getData(), 0, dp.getLength()));
        ds.close(); sc.close();
    }
}
