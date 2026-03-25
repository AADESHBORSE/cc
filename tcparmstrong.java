// TCPArmstrongServer.java
import java.io.*;
import java.net.*;

public class TCPArmstrongServer {
    static boolean isArmstrong(int n) {
        int original = n, sum = 0, digits = String.valueOf(n).length();
        while (n != 0) {
            sum += Math.pow(n % 10, digits);
            n /= 10;
        }
        return sum == original;
    }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int n = dis.readInt();
        dos.writeBoolean(isArmstrong(n));

        s.close(); ss.close();
    }
}

// TCPArmstrongClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPArmstrongClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(n);
        System.out.println(dis.readBoolean() ? "Armstrong" : "Not Armstrong");

        s.close(); sc.close();
    }
}
