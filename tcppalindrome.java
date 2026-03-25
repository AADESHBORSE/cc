// TCPPalindromeServer.java
import java.io.*;
import java.net.*;

public class TCPPalindromeServer {
    static boolean isPalindrome(int n) {
        int original = n, rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return original == rev;
    }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int n = dis.readInt();
        dos.writeBoolean(isPalindrome(n));

        s.close(); ss.close();
    }
}

// TCPPalindromeClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPPalindromeClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeInt(n);
        System.out.println(dis.readBoolean() ? "Palindrome" : "Not Palindrome");

        s.close(); sc.close();
    }
}
