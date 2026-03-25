// TCPToDecimalServer.java
import java.io.*;
import java.net.*;

public class TCPToDecimalServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String type = dis.readUTF();   // "binary", "octal", or "hex"
        String value = dis.readUTF();

        int result = 0;
        if (type.equals("binary")) result = Integer.parseInt(value, 2);
        else if (type.equals("octal")) result = Integer.parseInt(value, 8);
        else if (type.equals("hex")) result = Integer.parseInt(value, 16);

        dos.writeInt(result);
        s.close(); ss.close();
    }
}

// TCPToDecimalClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPToDecimalClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter type (binary/octal/hex): ");
        String type = sc.next();
        System.out.print("Enter value: ");
        String value = sc.next();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeUTF(type); dos.writeUTF(value);
        System.out.println("Decimal = " + dis.readInt());

        s.close(); sc.close();
    }
}
