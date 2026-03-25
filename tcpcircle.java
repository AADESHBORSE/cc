// TCPCircleServer.java
import java.io.*;
import java.net.*;

public class TCPCircleServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        double r = dis.readDouble();
        dos.writeDouble(Math.PI * r * r);       // Area
        dos.writeDouble(2 * Math.PI * r);       // Circumference

        s.close(); ss.close();
    }
}

// TCPCircleClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPCircleClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double r = sc.nextDouble();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeDouble(r);
        System.out.println("Area = " + dis.readDouble());
        System.out.println("Circumference = " + dis.readDouble());

        s.close(); sc.close();
    }
}
