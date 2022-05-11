package src.ip.ques;

import java.util.*;

public class Sol2 {
  private long calculateBootPower(int l, int r, long[] prefixSum, Queue<Integer> pq){
    int k = r - l + 1;
    long res = pq.peek() + k * (prefixSum[r] - (l>0?prefixSum[l-1]:0));
    return res;
  }

  public int findMaximumSustainableClusterSize(List<Integer> processingPower, List<Integer> bootingPower, long powerMax){
    final int size = processingPower.size();
    if(size == 0) return 0;

    Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    }); // Can use ST here - used to keep track of ranged maximum
    pq.add(0);
    pq.add(bootingPower.get(0));

    long prefixSumPP[] = new long[size];
    prefixSumPP[0] = processingPower.get(0);
    for (int i = 1; i < size; i++) {
      prefixSumPP[i] = prefixSumPP[i-1]+processingPower.get(i);
    }

    int l = 0; int r = 0;
    long res = Long.MIN_VALUE, powerReq = 0;
    while(r < size){
      powerReq = calculateBootPower(l, r, prefixSumPP, pq);
      if(powerReq <= powerMax){
        res = Long.max(res, powerReq);
        if(r<(size-1)) pq.add(bootingPower.get(++r));
        else r++;
      }else if(l<=r){
        pq.remove(bootingPower.get(l++));
      }
    }
    return (int)res;
  }

  public static void main(String []args){
    Sol2 sol2 = new Sol2();
    System.out.println(sol2.findMaximumSustainableClusterSize(Arrays.asList(2,1,3,4,5), Arrays.asList(3, 6, 3, 1, 4), 25));
  }
}
