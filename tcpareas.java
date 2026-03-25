// TCPShapeServer.java
import java.io.*;
import java.net.*;

public class TCPShapeServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String shape = dis.readUTF();
        double result = 0;

        switch (shape) {
            case "cube":
                double side = dis.readDouble();
                result = 6 * side * side;
                break;
            case "rectangle":
                double l = dis.readDouble(), b = dis.readDouble();
                result = l * b;
                break;
            case "cuboid":
                double cl = dis.readDouble(), cb = dis.readDouble(), ch = dis.readDouble();
                result = 2 * (cl*cb + cb*ch + cl*ch);
                break;
            case "square":
                double sq = dis.readDouble();
                result = sq * sq;
                break;
            case "cone":
                double r = dis.readDouble(), h = dis.readDouble();
                result = Math.PI * r * (r + Math.sqrt(h*h + r*r));
                break;
        }

        dos.writeDouble(result);
        s.close(); ss.close();
    }
}

// TCPShapeClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPShapeClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter shape (cube/rectangle/cuboid/square/cone): ");
        String shape = sc.next();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeUTF(shape);

        switch (shape) {
            case "cube": case "square":
                System.out.print("Enter side: ");
                dos.writeDouble(sc.nextDouble());
                break;
            case "rectangle":
                System.out.print("Enter length and breadth: ");
                dos.writeDouble(sc.nextDouble()); dos.writeDouble(sc.nextDouble());
                break;
            case "cuboid":
                System.out.print("Enter length, breadth, height: ");
                dos.writeDouble(sc.nextDouble()); dos.writeDouble(sc.nextDouble()); dos.writeDouble(sc.nextDouble());
                break;
            case "cone":
                System.out.print("Enter radius and height: ");
                dos.writeDouble(sc.nextDouble()); dos.writeDouble(sc.nextDouble());
                break;
        }

        System.out.println("Area = " + dis.readDouble());
        s.close(); sc.close();
    }
}

