// TCPSumListServer.java
import java.io.*;
import java.net.*;

public class TCPSumListServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String data = dis.readUTF();
        String[] nums = data.split(",");
        int sum = 0;
        for (String num : nums) sum += Integer.parseInt(num.trim());

        dos.writeInt(sum);
        s.close(); ss.close();
    }
}

// TCPSumListClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPSumListClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numbers separated by comma: ");
        String data = sc.nextLine();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeUTF(data);
        System.out.println("Sum = " + dis.readInt());

        s.close(); sc.close();
    }
}
