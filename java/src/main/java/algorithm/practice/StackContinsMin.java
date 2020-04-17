package algorithm.practice;

import algorithm.algs4.Stack;

/**
 * User: 20160301301
 * Date: 2017/11/22 9:13
 * Comment: 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class StackContinsMin {

    private Stack<Integer> mDate = new Stack<Integer>();
    private Stack<Integer> mMin = new Stack<Integer>();

    public void push(int node) {
        mDate.push(node);
        if (mMin.size() == 0 || node < mMin.peek()) {
            mMin.push(node);
        } else {
            mMin.push(mMin.peek());
        }
    }

    public void pop() {
        if (mDate.size() > 0 && mMin.size() > 0) {
            mDate.pop();
            mMin.pop();
        }
    }

    public int top() {
        return mDate.peek();
    }

    public int min() {
        if (mDate.size() > 0 && mMin.size() > 0) {
            return mMin.peek();
        }
        return 0;
    }

    public static void main(String[] args) {
        StackContinsMin stackContinsMin = new StackContinsMin();
        args = new String[]{"PSH3", "MIN", "PSH4", "MIN", "PSH2", "MIN", "PSH3", "MIN", "POP", "MIN", "POP", "MIN", "POP", "MIN", "PSH0", "MIN"};
        for (String s:args) {
            stackContinsMin.mMin.push(Integer.getInteger(s));
            stackContinsMin.mDate.push(Integer.getInteger(s));
        }
        System.out.println(stackContinsMin.mDate.size());
        System.out.println(stackContinsMin.mMin.size());
        System.out.println(stackContinsMin.min());
    }
}
