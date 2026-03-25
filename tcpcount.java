// TCPCountDigitsServer.java
import java.io.*;
import java.net.*;

public class TCPCountDigitsServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int n = dis.readInt();
        int count = String.valueOf(Math.abs(n)).length();
        dos.writeInt(count);

        s.close(); ss.close();
    }
}

// TCPCountDigitsClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPCountDigitsClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(n);
        System.out.println("Number of digits = " + dis.readInt());

        s.close(); sc.close();
    }
}
