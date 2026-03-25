// TCPLCMServer.java
import java.io.*;
import java.net.*;

public class TCPLCMServer {
    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int a = dis.readInt(), b = dis.readInt();
        int lcm = (a * b) / gcd(a, b);
        dos.writeInt(lcm);

        s.close(); ss.close();
    }
}

// TCPLCMClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPLCMClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt(), b = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(a); dos.writeInt(b);
        System.out.println("LCM = " + dis.readInt());

        s.close(); sc.close();
    }
}
