package me.hope.practice.algorithm.chap01_stack_queue;

import java.util.Stack;

/**
 * 一个有getMin()功能的栈
 * 此栈中包含两个数据栈，一个保存数据，一个保存最小值。最小值考虑到冗余，当前值大于最小值时，最小值可不重新插入
 * 参考：http://www.ruanyifeng.com/blog/2013/11/stack.html
 *
 * @author hope
 * @data 2016-10-13 24:47
 */
public class StackWithGetMin {
    private Stack<Integer> dataStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int num) {
        if(this.minStack.isEmpty()) {
            this.minStack.push(num);
        } else if(num <= this.getMin()) {
            this.minStack.push(num);
        }
        this.dataStack.push(num);
    }

    public int pop() {
        if(this.dataStack.isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        int value = this.dataStack.pop();
        if (value == this.getMin()) {
            this.minStack.pop();
        }
        return value;
    }

    public int getMin() {
        if(this.minStack.isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        return this.minStack.peek();
    }

    public static void main(String[] args) {
        StackWithGetMin stack = new StackWithGetMin();

        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(2);
        stack.push(3);
        stack.push(1);

        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

    }
}
