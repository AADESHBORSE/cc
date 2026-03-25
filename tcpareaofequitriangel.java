// TCPTriangleServer.java
import java.io.*;
import java.net.*;

public class TCPTriangleServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        double side = dis.readDouble();
        double area = (Math.sqrt(3) / 4) * side * side;
        dos.writeDouble(area);

        s.close(); ss.close();
    }
}

// TCPTriangleClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPTriangleClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side of equilateral triangle: ");
        double side = sc.nextDouble();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeDouble(side);
        System.out.println("Area = " + dis.readDouble());

        s.close(); sc.close();
    }
}
