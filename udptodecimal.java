// UDPToDecimalServer.java
import java.net.*;

public class UDPToDecimalServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);

        // Format: "binary,1010" or "octal,17" or "hex,FF"
        String[] parts = new String(dp.getData(), 0, dp.getLength()).split(",");
        String type = parts[0], value = parts[1];

        int result = 0;
        if (type.equals("binary")) result = Integer.parseInt(value, 2);
        else if (type.equals("octal")) result = Integer.parseInt(value, 8);
        else if (type.equals("hex")) result = Integer.parseInt(value, 16);

        byte[] send = String.valueOf(result).getBytes();
        ds.send(new DatagramPacket(send, send.length, dp.getAddress(), dp.getPort()));
        ds.close();
    }
}
// UDPToDecimalClient.java
import java.net.*;
import java.util.Scanner;

public class UDPToDecimalClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter type (binary/octal/hex): ");
        String type = sc.next();
        System.out.print("Enter value: ");
        String value = sc.next();

        byte[] send = (type + "," + value).getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        ds.send(new DatagramPacket(send, send.length, ip, 5000));

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);
        System.out.println("Decimal = " + new String(dp.getData(), 0, dp.getLength()));
        ds.close(); sc.close();
    }
}
