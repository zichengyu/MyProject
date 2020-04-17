package middleware.netty.block;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: 20160301301
 * Date: 2017/11/7 14:45
 * Comment:
 */
public class TimeServer {

    public static void main(String[] args) throws Exception {
        int port = 8035;
        if (args != null && args.length > 0 ) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The TimeServer is start in port" + port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);
            while (true) {
                socket = server.accept();
//                new Thread(new TimeServerHandler(socket)).start();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null) {
                System.out.println("The TimeServer is stop");
                server.close();
                server = null;
            }
        }
    }
}