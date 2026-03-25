// TCPFibonacciServer.java
import java.io.*;
import java.net.*;

public class TCPFibonacciServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int n = dis.readInt();
        StringBuilder sb = new StringBuilder();
        int a = 0, b = 1;
        while (a <= n) {
            sb.append(a).append(" ");
            int next = a + b;
            a = b; b = next;
        }

        // Send result as String
        byte[] send = sb.toString().trim().getBytes();
        dos.writeInt(send.length);   // Send length first
        dos.write(send);             // Then send the string bytes

        s.close(); ss.close();
    }
}

// TCPFibonacciClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPFibonacciClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter range: ");
        int n = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(n);

        int len = dis.readInt();
        byte[] receive = new byte[len];
        dis.readFully(receive);
        System.out.println("Fibonacci series: " + new String(receive));

        s.close(); sc.close();
    }
}
