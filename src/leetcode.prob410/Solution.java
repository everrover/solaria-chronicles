package leetcode.prob410;// All required std imports

import java.util.Arrays;

/**
Link: https://leetcode.com/problems/split-array-largest-sum/
*/
class Solution {
    private static int []sums;
    private static int [][]dp;
    public int splitArray(int[] nums, int m) {
        sums = new int[nums.length];
        dp = new int[nums.length][m];
        for(int[] dps: dp){
            Arrays.fill(dps, -1);
        }
        sums[0] = nums[0];
        for(int i=1; i<sums.length; i++){
            sums[i] = sums[i-1]+nums[i];
        }
        return utils(nums, m, 0);
    }
    
    private int utils(int nums[], int m, int idx){
        int sumAtIdx = idx == 0? 0: sums[idx-1];
        if(dp[idx][m-1]!=-1) return dp[idx][m-1];
        if(m==1) {
            dp[idx][0] = sums[sums.length-1]-sumAtIdx;
            return dp[idx][0];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=idx; i<=(nums.length-m); i++){
            int sol = Integer.max(sums[i]-sumAtIdx, utils(nums, m-1, i+1));
            ans = Integer.min(ans, sol);
        }
        dp[idx][m-1] = ans;
        return ans;
    }
}
