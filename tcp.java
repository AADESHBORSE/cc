import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPAddClient {
    public static void main(String[] args) throws Exception {
       Socket s = new Socket("localhost", 5000);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(num1);
        dos.writeInt(num2);

        int result = dis.readInt();
        System.out.println("Sum = " + result);

        s.close();
        sc.close();
    }
}


import java.io.*;
import java.net.*;

public class TCPAddServer {
    public static void main(String[] args) throws Exception {
       ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");

        Socket s = ss.accept();
        System.out.println("Client connected");

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int num1 = dis.readInt();
        int num2 = dis.readInt();

        int sum = num1 + num2;

        dos.writeInt(sum);

        s.close();
        ss.close();
    }
}
