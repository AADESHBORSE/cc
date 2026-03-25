// MulticastArmstrongReceiver.java
import java.net.*;

public class MulticastArmstrongReceiver {
    static boolean isArmstrong(int n) {
        int original = n, sum = 0, digits = String.valueOf(n).length();
        while (n != 0) {
            sum += Math.pow(n % 10, digits);
            n /= 10;
        }
        return sum == original;
    }

    public static void main(String[] args) throws Exception {
        MulticastSocket ms = new MulticastSocket(5000);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ms.joinGroup(group);

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ms.receive(dp);

        int n = Integer.parseInt(new String(dp.getData(), 0, dp.getLength()));
        System.out.println(isArmstrong(n) ? "Armstrong" : "Not Armstrong");

        ms.leaveGroup(group); ms.close();
    }
}

// MulticastArmstrongSender.java
import java.net.*;
import java.util.Scanner;

public class MulticastArmstrongSender {
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
