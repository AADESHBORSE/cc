// TCPSumNaturalServer.java
import java.io.*;
import java.net.*;

public class TCPSumNaturalServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int n = dis.readInt();
        int sum = n * (n + 1) / 2;
        dos.writeInt(sum);

        s.close(); ss.close();
    }
}

// TCPSumNaturalClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPSumNaturalClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(n);
        System.out.println("Sum = " + dis.readInt());

        s.close(); sc.close();
    }
}
