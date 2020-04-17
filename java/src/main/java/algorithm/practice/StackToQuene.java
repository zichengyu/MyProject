package algorithm.practice;

import java.util.Iterator;
import java.util.Stack;

/**
 * User: 20160301301
 * Date: 2017/11/2 8:36
 * Comment: 两个栈模仿一个队列
 */
public class StackToQuene {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            Iterator<Integer> iterator = stack1.iterator();
            while (iterator.hasNext()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return 0;
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackToQuene stackToQuene = new StackToQuene();
        stackToQuene.push(1);
        stackToQuene.push(2);
        stackToQuene.push(3);
        System.out.println(stackToQuene.pop());
        System.out.println(stackToQuene.pop());
        stackToQuene.push(4);
        stackToQuene.push(5);
        System.out.println(stackToQuene.pop());
    }
}