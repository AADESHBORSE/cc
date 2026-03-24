import java.net.*;
import java.util.Scanner;

public class UDPAddClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        String msg = num1 + "," + num2;
        byte[] send = msg.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket dp = new DatagramPacket(send, send.length, ip, 5000);
        ds.send(dp);
        byte[] receive = new byte[1024];
        DatagramPacket dpReceive = new DatagramPacket(receive, receive.length);
        ds.receive(dpReceive);
        String result = new String(dpReceive.getData(), 0, dpReceive.getLength());
        System.out.println("Sum = " + result);
        ds.close();
        sc.close();
    }
}


import java.net.*;

public class UDPAddServer {
    public static void main(String[] args) throws Exception {
                DatagramSocket ds = new DatagramSocket(5000);
        byte[] receive = new byte[1024];

        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);

        String data = new String(dp.getData(), 0, dp.getLength());
        String[] numbers = data.split(",");

        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);

        int sum = num1 + num2;

        String result = String.valueOf(sum);
        byte[] send = result.getBytes();

        DatagramPacket dpSend = new DatagramPacket(send, send.length,
                dp.getAddress(), dp.getPort());

        ds.send(dpSend);
        ds.close();
    }
}
