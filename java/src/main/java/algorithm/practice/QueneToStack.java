package algorithm.practice;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: 20160301301
 * Date: 2017/11/2 9:19
 * Comment:两个队列模仿一个栈
 */
public class QueneToStack {
    private LinkedBlockingQueue<Integer> queue1 = new LinkedBlockingQueue();
    private LinkedBlockingQueue<Integer> queue3 = new LinkedBlockingQueue();

    public void push(int node) {
        if (queue3.isEmpty()) {
            queue1.offer(node);
        } else {
            queue3.offer(node);
        }
    }

    public int pop() {
        if (queue1.isEmpty() && queue3.isEmpty()) {
            return 0;
        }
        if (queue1.isEmpty()) {
            LinkedBlockingQueue<Integer> queue = queue1;
            queue1 = queue3;
            queue3 = queue;
        }
        int size = queue1.size()- 1;
        for (int i = 0; i< size; i++) {
            queue3.offer(queue1.poll());
        }
        return queue1.poll();
    }

    public static void main(String[] args) {
        QueneToStack queneToStack = new QueneToStack();
        queneToStack.push(1);
        queneToStack.push(2);
        queneToStack.push(3);
        System.out.println(queneToStack.pop());
        System.out.println(queneToStack.pop());
        queneToStack.push(4);
        queneToStack.push(5);
        System.out.println(queneToStack.pop());
        System.out.println(queneToStack.pop());
        System.out.println(queneToStack.pop());
    }
}