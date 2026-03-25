// MulticastDecimalConvertReceiver.java
import java.net.*;

public class MulticastDecimalConvertReceiver {
    public static void main(String[] args) throws Exception {
        MulticastSocket ms = new MulticastSocket(5000);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ms.joinGroup(group);

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ms.receive(dp);

        int n = Integer.parseInt(new String(dp.getData(), 0, dp.getLength()));
        System.out.println("Binary=" + Integer.toBinaryString(n));
        System.out.println("Octal=" + Integer.toOctalString(n));
        System.out.println("Hex=" + Integer.toHexString(n).toUpperCase());

        ms.leaveGroup(group); ms.close();
    }
}
// MulticastDecimalConvertSender.java
import java.net.*;
import java.util.Scanner;

public class MulticastDecimalConvertSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int n = sc.nextInt();

        byte[] send = String.valueOf(n).getBytes();
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ds.send(new DatagramPacket(send, send.length, group, 5000));
        ds.close(); sc.close();
    }
}
