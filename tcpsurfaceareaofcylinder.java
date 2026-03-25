// TCPCylinderServer.java
import java.io.*;
import java.net.*;

public class TCPCylinderServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        double r = dis.readDouble(), h = dis.readDouble();
        double sa = 2 * Math.PI * r * (r + h);
        dos.writeDouble(sa);

        s.close(); ss.close();
    }
}

// TCPCylinderClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPCylinderClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius and height: ");
        double r = sc.nextDouble(), h = sc.nextDouble();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeDouble(r); dos.writeDouble(h);
        System.out.println("Surface Area = " + dis.readDouble());

        s.close(); sc.close();
    }
}
