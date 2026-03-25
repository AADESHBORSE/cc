// TCPGreatestServer.java
import java.io.*;
import java.net.*;

public class TCPGreatestServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int a = dis.readInt(), b = dis.readInt(), c = dis.readInt();
        int greatest = (a >= b && a >= c) ? a : (b >= c ? b : c);
        dos.writeInt(greatest);

        s.close(); ss.close();
    }
}

// TCPGreatestClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPGreatestClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter three numbers: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(a); dos.writeInt(b); dos.writeInt(c);
        System.out.println("Greatest = " + dis.readInt());

        s.close(); sc.close();
    }
}
