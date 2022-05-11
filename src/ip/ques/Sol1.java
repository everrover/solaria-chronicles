package src.ip.ques;

import java.util.*;

public class Sol1 {
  private static long getHeaviestPackage(List<Integer> packageWeights){
    Stack<Long> stack = new Stack<>();
    stack.add(0L);
    for(int i = packageWeights.size()-1; i>=0; i--){
      long n = packageWeights.get(i);
      if(stack.peek() > n){
        stack.add(stack.pop()+n);
      }else{
        stack.add(n);
      }
    }
    long res = 0;
    while(!stack.empty()){
      res = Math.max(stack.pop(), res);
    }
    return res;
  }
  public static void main(String[] args) {
    getHeaviestPackage(Arrays.asList(new Integer[]{2, 9, 10, 3, 7}));
  }
}
// 2, 9, 10, 3, 7