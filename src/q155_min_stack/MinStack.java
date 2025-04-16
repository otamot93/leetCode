package q155_min_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<Integer> numbers;
    private Deque<Integer> minNumbers;
    public MinStack() {
        numbers = new ArrayDeque<>();
        minNumbers = new ArrayDeque<>();
    }
    
    public void push(int val) {
        numbers.push(val);
        // 获取入栈前最小的数，和当前比较，较小的值入栈
        if(minNumbers.size()>0){
            minNumbers.push(Integer.min(val, minNumbers.peek()));
        }else{
            minNumbers.push(val);
        }
    }
    
    public void pop() {
        numbers.pop();
        minNumbers.pop();
    }
    
    public int top() {
        return numbers.peek();
    }
    
    public int getMin() {
        return minNumbers.peek();
    }
}
