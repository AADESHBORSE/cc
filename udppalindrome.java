// UDPPalindromeServer.java
import java.net.*;

public class UDPPalindromeServer {
    static boolean isPalindrome(int n) {
        int original = n, rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return original == rev;
    }

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);

        int n = Integer.parseInt(new String(dp.getData(), 0, dp.getLength()));
        String result = isPalindrome(n) ? "Palindrome" : "Not Palindrome";
        byte[] send = result.getBytes();
        ds.send(new DatagramPacket(send, send.length, dp.getAddress(), dp.getPort()));
        ds.close();
    }
}

// UDPPalindromeClient.java
import java.net.*;
import java.util.Scanner;

public class UDPPalindromeClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        byte[] send = String.valueOf(n).getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        ds.send(new DatagramPacket(send, send.length, ip, 5000));

        byte[] receive = new byte[1024];
        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);
        System.out.println(new String(dp.getData(), 0, dp.getLength()));
        ds.close(); sc.close();
    }
}
