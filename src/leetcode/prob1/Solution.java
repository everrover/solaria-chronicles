package leetcode.prob1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int sol[] = new int[2];

        class Pair implements Comparable<Pair>{
            public int value;
            public int index;

            Pair(int value, int index){
                this.value = value;
                this.index = index;
            }

            @Override
            public int compareTo(Pair o){
                return this.value - o.value;
            }
        }

        List<Pair> arr = new ArrayList<>();

        for(int k=0; k<nums.length; k++){
            arr.add(new Pair(nums[k], k));
        }

        Collections.sort(arr);

        int i=0, j=nums.length-1;

        while(i<j){
            if((arr.get(i).value+arr.get(j).value) < target){
                i++;
            } else if ((arr.get(i).value+arr.get(j).value) > target) {
                j--;
            } else {
                break;
            }
        }
        sol[0] = arr.get(i).index;
        sol[1] = arr.get(j).index;
        return sol;
    }
}