// TCPDecimalConvertServer.java
import java.io.*;
import java.net.*;

public class TCPDecimalConvertServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int n = dis.readInt();
        String result = "Binary=" + Integer.toBinaryString(n) +
                        ", Octal=" + Integer.toOctalString(n) +
                        ", Hex=" + Integer.toHexString(n).toUpperCase();
        dos.writeUTF(result);

        s.close(); ss.close();
    }
}

// TCPDecimalConvertClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPDecimalConvertClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int n = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(n);
        System.out.println(dis.readUTF());

        s.close(); sc.close();
    }
}
