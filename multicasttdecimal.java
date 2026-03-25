// MulticastToDecimalReceiver.java
import java.net.*;

public class MulticastToDecimalReceiver {
    public static void main(String[] args) throws Exception {
        MulticastSocket ms = new MulticastSocket(5000);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ms.joinGroup(group);

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ms.receive(dp);

        String[] parts = new String(dp.getData(), 0, dp.getLength()).split(",");
        String type = parts[0], value = parts[1];
        int result = 0;
        if (type.equals("binary")) result = Integer.parseInt(value, 2);
        else if (type.equals("octal")) result = Integer.parseInt(value, 8);
        else if (type.equals("hex")) result = Integer.parseInt(value, 16);
        System.out.println("Decimal = " + result);

        ms.leaveGroup(group); ms.close();
    }
}

// MulticastToDecimalSender.java
import java.net.*;
import java.util.Scanner;

public class MulticastToDecimalSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter type (binary/octal/hex): ");
        String type = sc.next();
        System.out.print("Enter value: ");
        String value = sc.next();

        byte[] send = (type + "," + value).getBytes();
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ds.send(new DatagramPacket(send, send.length, group, 5000));
        ds.close(); sc.close();
    }
}
