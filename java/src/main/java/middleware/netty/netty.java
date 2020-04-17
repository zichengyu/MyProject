package middleware.netty;

import io.netty.buffer.*;

import java.nio.ByteBuffer;

/**
 * User: 20160301301
 * Date: 2018/3/16 14:31
 * Comment:
 */
public class netty {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        String value = "netty权威指南";
        byteBuffer.put(value.getBytes());
        byteBuffer.flip();
        byte[] varray = new byte[byteBuffer.remaining()];
        byteBuffer.get(varray);
        String decode = new String(varray);
        System.out.println(decode);

        testNetty();
    }

    private static void testNetty() {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        byteBuf.writeBytes("欢迎您".getBytes());
        PooledByteBufAllocator.DEFAULT.buffer();
        System.out.println(ByteBufUtil.hexDump(byteBuf));


    }
}
