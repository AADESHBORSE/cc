// TCPReverseServer.java
import java.io.*;
import java.net.*;

public class TCPReverseServer {
    static int reverse(int n, int rev) {
        if (n == 0) return rev;
        return reverse(n / 10, rev * 10 + n % 10);
    }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();
        System.out.println("Client connected");

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int n = dis.readInt();
        dos.writeInt(reverse(n, 0));

        s.close(); ss.close();
    }
}

// TCPReverseClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPReverseClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(n);
        System.out.println("Reversed = " + dis.readInt());

        s.close(); sc.close();
    }
}
