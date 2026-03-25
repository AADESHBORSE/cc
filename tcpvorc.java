// TCPVowelServer.java
import java.io.*;
import java.net.*;

public class TCPVowelServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        char c = dis.readChar();
        c = Character.toLowerCase(c);
        String result = "aeiou".indexOf(c) != -1 ? "Vowel" : "Consonant";
        dos.writeUTF(result);

        s.close(); ss.close();
    }
}

// TCPVowelClient.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPVowelClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char c = sc.next().charAt(0);

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        dos.writeChar(c);
        System.out.println(dis.readUTF());

        s.close(); sc.close();
    }
}
