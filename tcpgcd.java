// TCPGCDServer.java
import java.io.*;
import java.net.*;

public class TCPGCDServer {
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int a = dis.readInt(), b = dis.readInt();
        dos.writeInt(gcd(a, b));

        s.close(); ss.close();
    }
}

// TCPGCDClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPGCDClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt(), b = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(a); dos.writeInt(b);
        System.out.println("GCD = " + dis.readInt());

        s.close(); sc.close();
    }
}
