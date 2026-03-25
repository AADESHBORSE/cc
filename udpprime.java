// UDPPrimeServer.java
import java.net.*;

public class UDPPrimeServer {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);

        String[] nums = new String(dp.getData(), 0, dp.getLength()).split(",");
        int start = Integer.parseInt(nums[0]), end = Integer.parseInt(nums[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++)
            if (isPrime(i)) sb.append(i).append(" ");

        byte[] send = sb.toString().trim().getBytes();
        ds.send(new DatagramPacket(send, send.length, dp.getAddress(), dp.getPort()));
        ds.close();
    }
}

// UDPPrimeClient.java
import java.net.*;
import java.util.Scanner;

public class UDPPrimeClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter start and end of range: ");
        int start = sc.nextInt(), end = sc.nextInt();

        byte[] send = (start + "," + end).getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        ds.send(new DatagramPacket(send, send.length, ip, 5000));

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);
        System.out.println("Primes: " + new String(dp.getData(), 0, dp.getLength()));
        ds.close(); sc.close();
    }
}
