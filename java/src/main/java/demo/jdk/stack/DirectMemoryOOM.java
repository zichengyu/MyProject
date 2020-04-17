package demo.jdk.stack;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * User: 20160301301
 * Date: 2018/5/2 16:28
 * Comment:
 */
public class DirectMemoryOOM {
    private static final int _1mb = 1024 * 1024;
    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = ((Unsafe) field.get(null));
        while (true) {
            unsafe.allocateMemory(_1mb);
        }
    }
}
