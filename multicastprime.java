// MulticastPrimeReceiver.java
import java.net.*;

public class MulticastPrimeReceiver {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        MulticastSocket ms = new MulticastSocket(5000);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ms.joinGroup(group);

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ms.receive(dp);

        String[] nums = new String(dp.getData(), 0, dp.getLength()).split(",");
        int start = Integer.parseInt(nums[0]), end = Integer.parseInt(nums[1]);

        System.out.print("Primes: ");
        for (int i = start; i <= end; i++)
            if (isPrime(i)) System.out.print(i + " ");

        ms.leaveGroup(group); ms.close();
    }
}

// MulticastPrimeSender.java
import java.net.*;
import java.util.Scanner;

public class MulticastPrimeSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter start and end of range: ");
        int start = sc.nextInt(), end = sc.nextInt();

        byte[] send = (start + "," + end).getBytes();
        InetAddress group = InetAddress.getByName("230.0.0.1");
        ds.send(new DatagramPacket(send, send.length, group, 5000));
        ds.close(); sc.close();
    }
}
