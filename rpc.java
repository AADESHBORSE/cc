import java.net.*;
import java.io.*;

class Client {
    public static void main(String args[]) {
        new Client();
        try {
            DatagramSocket ds = new DatagramSocket(1000);
            String st = args[0] + " " + args[1];

            DatagramPacket dp = new DatagramPacket(st.getBytes(),
                    st.length(), InetAddress.getLocalHost(), 2000);
            ds.send(dp);

            byte b[] = new byte[256];
            dp = new DatagramPacket(b, b.length);
            ds.receive(dp);

            String msg = new String(dp.getData());
            msg = msg.trim();
            System.out.println("Addition is " + msg);
        } catch (Exception e) {
        }
    }
}

import java.net.*;
import java.io.*;

class Server {

    public int add(int a, int b) {
        return (a + b);
    }

    public static void main(String args[]) {
        Server ser = new Server();
        try {
            DatagramSocket ds = new DatagramSocket(2000);
            byte b[] = new byte[256];

            DatagramPacket dp = new DatagramPacket(b, b.length);
            ds.receive(dp);

            String st = new String(dp.getData());
            System.out.println("st " + st);

            String data[] = st.split(" ");
            data[0] = data[0].trim();
            data[1] = data[1].trim();

            int i = Integer.parseInt(data[0]);
            int j = Integer.parseInt(data[1]);

            System.out.println(i);
            int ans = ser.add(i, j);

            String msg = Integer.toString(ans);
            System.out.println(msg);

            dp = new DatagramPacket(msg.getBytes(), msg.length(),
                    InetAddress.getLocalHost(), 1000);
            ds.send(dp);

        } catch (Exception e) {
        }
    }
}
