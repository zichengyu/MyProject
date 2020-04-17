package middleware.netty.block;

import java.io.*;
import java.net.Socket;

/**
 * User: 20160301301
 * Date: 2017/11/7 15:16
 * Comment:
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8035;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            out.println("QUERY TIME ORDER");
            System.out.println("Send order 2 server succeed.");
            String resp = in.readLine();
            System.out.println("Now is : " + resp);
        } catch (IOException e) {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException el) {
                    el.printStackTrace();
                }
            }
            if (out != null) {
                out.close();
                out = null;
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException el) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}