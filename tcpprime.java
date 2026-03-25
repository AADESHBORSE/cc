// TCPPrimeServer.java
import java.io.*;
import java.net.*;

public class TCPPrimeServer {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int start = dis.readInt(), end = dis.readInt();
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++)
            if (isPrime(i)) sb.append(i).append(" ");

        byte[] send = sb.toString().trim().getBytes();
        dos.writeInt(send.length);
        dos.write(send);

        s.close(); ss.close();
    }
}

// TCPPrimeClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPPrimeClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter start and end of range: ");
        int start = sc.nextInt(), end = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(start); dos.writeInt(end);

        int len = dis.readInt();
        byte[] receive = new byte[len];
        dis.readFully(receive);
        System.out.println("Primes: " + new String(receive));

        s.close(); sc.close();
    }
}
