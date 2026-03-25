// MulticastFibonacciReceiver.java
import java.net.*;

public class MulticastFibonacciReceiver {
    public static void main(String[] args) throws Exception {
        MulticastSocket ms = new MulticastSocket(5000);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ms.joinGroup(group);

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ms.receive(dp);

        int n = Integer.parseInt(new String(dp.getData(), 0, dp.getLength()));
        int a = 0, b = 1;
        System.out.print("Fibonacci: ");
        while (a <= n) {
            System.out.print(a + " ");
            int next = a + b;
            a = b; b = next;
        }

        ms.leaveGroup(group); ms.close();
    }
}

// MulticastFibonacciSender.java
import java.net.*;
import java.util.Scanner;

public class MulticastFibonacciSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter range: ");
        int n = sc.nextInt();

        byte[] send = String.valueOf(n).getBytes();
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ds.send(new DatagramPacket(send, send.length, group, 5000));
        ds.close(); sc.close();
    }
}
