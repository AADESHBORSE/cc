import java.net.*;

public class MulticastAddReceiver {
    public static void main(String[] args) throws Exception {
        MulticastSocket ms = new MulticastSocket(5000);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ms.joinGroup(group);

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ms.receive(dp);

        String data = new String(dp.getData(), 0, dp.getLength());
        String[] numbers = data.split(",");

        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);

        int sum = num1 + num2;
        System.out.println("Sum = " + sum);

        ms.leaveGroup(group);
        ms.close();
    }
}


import java.net.*;
import java.util.Scanner;

public class MulticastAddSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        String msg = num1 + "," + num2;
        byte[] send = msg.getBytes();

        InetAddress group = InetAddress.getByName("230.0.0.1");
        DatagramPacket dp = new DatagramPacket(send, send.length, group, 5000);

        ds.send(dp);
        ds.close();
        sc.close();
    }
}
