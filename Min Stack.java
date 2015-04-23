/**
 * Solution to https://leetcode.com/problems/min-stack/
 */
import java.util.Stack;

class MinStack {
  Stack<Integer> stack = new Stack<Integer>();
  Stack<Integer> min_list = new Stack<Integer>();
  public void push(int x) {        
    if(min_list.empty() || x<=min_list.peek())            
      min_list.push(x);
    stack.push(x);
  }
  public void pop() {
    if(!stack.empty() && stack.pop().equals(min_list.peek()))
      min_list.pop();
  }
  public int top() {
    return stack.peek();
  }
  public int getMin() {
    return min_list.peek();
  }
}
