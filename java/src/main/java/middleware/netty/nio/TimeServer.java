package middleware.netty.nio;

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
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}