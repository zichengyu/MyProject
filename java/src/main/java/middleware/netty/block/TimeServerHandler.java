package middleware.netty.block;

import java.io.*;
import java.net.Socket;

/**
 * User: 20160301301
 * Date: 2017/11/7 15:00
 * Comment:
 */
public class TimeServerHandler implements Runnable {
    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream()), true);
            String currentTime = null;
            String body = null;
            while (true) {
                body = in.readLine();
                if (body == null) {
                    break;
                }
                System.out.println("The TimeServer receive order : " + body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
                        ? new java.util.Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                out.println(currentTime);
            }
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
            if (this.socket != null) {
                try {
                    this.socket.close();
                } catch (IOException el) {
                    e.printStackTrace();
                }
                this.socket = null;
            }
        }

    }
}
