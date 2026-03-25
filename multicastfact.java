// MulticastFactorialReceiver.java
import java.net.*;

public class MulticastFactorialReceiver {
    static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) throws Exception {
        MulticastSocket ms = new MulticastSocket(5000);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ms.joinGroup(group);

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ms.receive(dp);

        int n = Integer.parseInt(new String(dp.getData(), 0, dp.getLength()));
        System.out.println("Factorial = " + factorial(n));

        ms.leaveGroup(group); ms.close();
    }
}

// MulticastFactorialSender.java
import java.net.*;
import java.util.Scanner;

public class MulticastFactorialSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        byte[] send = String.valueOf(n).getBytes();
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ds.send(new DatagramPacket(send, send.length, group, 5000));
        ds.close(); sc.close();
    }
}
