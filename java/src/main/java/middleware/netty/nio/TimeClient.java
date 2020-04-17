package middleware.netty.nio;

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
        new Thread(new TimeClientHandler("127.0.0.1", port), "TimeClient-001").start();
        ;
    }
}