package crackingthecodinginterview.chapter3;

/**
 * Created by paulberesuita on 9/7/15.
 */
public class question1 {

    public static void main(String[] args) {

        String testString = "hello";

    }

    public static class threeStack {

        int stackSize = 100;
        int[] buffer = new int[stackSize * 3];
        int[] stackPointer = {-1, -1, -1};

        public void push(int stackNum, int value) {
            stackPointer[stackNum]++;
            buffer[absTopOfStack(stackNum)] = value;
        }

        public int pop(int stackNum) {
            int value = buffer[absTopOfStack(stackNum)];
            buffer[absTopOfStack(stackNum)] = 0;
            stackPointer[stackNum]--;
            return value;
        }

        public int peek(int stackNum) {
            int index = absTopOfStack(stackNum);
            return buffer[index];
        }

        public int absTopOfStack(int stackNum) {
            return stackNum * stackSize + stackPointer[stackNum];
        }

    }
}
