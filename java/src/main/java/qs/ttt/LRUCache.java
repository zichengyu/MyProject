package qs.ttt;

import java.util.HashMap;
import java.util.Map;

/**
 * 类的描述
 *
 * @author: yuzicheng
 * @since: 8/13/21 2:15 下午
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, CacheNode> map;
    private CacheNode head;
    private CacheNode tail;

    private class CacheNode {
        private int key;
        private int value;
        private CacheNode pre;
        private CacheNode next;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new CacheNode(-1, -1);
        tail = new CacheNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        CacheNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        delNode(node);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        CacheNode node = map.get(key);
        if (node != null) {
            node.value = value;
            delNode(node);
            moveToHead(node);
            return;
        }
        checkCapacity();
        node = new CacheNode(key, value);
        map.put(key, node);
        moveToHead(node);
    }

    private void checkCapacity() {
        if (map.size() < capacity) {
            return;
        }
        CacheNode remove = tail.pre;
        delNode(remove);
        map.remove(remove.key);
    }

    private void delNode(CacheNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    private void moveToHead(CacheNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}
