package datastructures.stack;

/**
 * Created by paulberesuita on 9/7/15.
 */
public class StackArray {

    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackArray(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int j) {
        stackArray[++top] = j;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

}
