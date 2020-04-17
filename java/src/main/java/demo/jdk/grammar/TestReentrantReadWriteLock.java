package demo.jdk.grammar;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * User: 20160301301
 * Date: 2018/3/20 15:58
 * Comment:
 * 1、writeLock支持condition，readLock本身支持多线程迸发访问，所以condition控制对readLock没什么用
 * 2、writeLock变成readLock成为锁降级，readLock无法变成writeLock
 * 3、readLock可多线程并发执行，writeLock只能单线程执行
 */
public class TestReentrantReadWriteLock {

    private static Map<String, Object> data = new HashMap<>();
    private static ReadWriteLock lock = new ReentrantReadWriteLock(false);
    private static Lock rlock = lock.readLock();
    private static Lock wlock = lock.writeLock();

    public static Object get(String key) {
        rlock.lock();
        try {
            return data.get(key);
        } finally {
            rlock.unlock();
        }
    }

    public static Object put(String key, Object value) {
        wlock.lock();
        try {
            return data.put(key, value);
        } finally {
            wlock.unlock();
        }
    }
}

