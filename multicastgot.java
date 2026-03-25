// MulticastGreatestReceiver.java
import java.net.*;

public class MulticastGreatestReceiver {
    public static void main(String[] args) throws Exception {
        MulticastSocket ms = new MulticastSocket(5000);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ms.joinGroup(group);

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ms.receive(dp);

        String[] nums = new String(dp.getData(), 0, dp.getLength()).split(",");
        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);
        int c = Integer.parseInt(nums[2]);
        int greatest = (a >= b && a >= c) ? a : (b >= c ? b : c);
        System.out.println("Greatest = " + greatest);

        ms.leaveGroup(group); ms.close();
    }
}

// MulticastGreatestSender.java
import java.net.*;
import java.util.Scanner;

public class MulticastGreatestSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter three numbers: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        byte[] send = (a + "," + b + "," + c).getBytes();
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ds.send(new DatagramPacket(send, send.length, group, 5000));
        ds.close(); sc.close();
    }
}
