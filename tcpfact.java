// TCPFactorialServer.java
import java.io.*;
import java.net.*;

public class TCPFactorialServer {
    static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int n = dis.readInt();
        dos.writeLong(factorial(n));

        s.close(); ss.close();
    }
}

// TCPFactorialClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPFactorialClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(n);
        System.out.println("Factorial = " + dis.readLong());

        s.close(); sc.close();
    }
}
