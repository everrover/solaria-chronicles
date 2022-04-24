package leetcode.prob312;

class Solution {
    public int maxCoins(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];
        return maxCoins(nums, dp, 0, nums.length-1);
    }
    private int maxCoins(int nums[], int dp[][], int first, int last){
        if(first>last) return 0;
        if(dp[first][last] > 0) return dp[first][last];
        int ans = 0;
        for(int i=first; i<=last; i++){
            int coinsGainedAfterPoppingIthInEnd = (first>0?nums[first-1]:1)*nums[i]*(last<(nums.length-1)?nums[last+1]:1);
            int coinsGainedAfterPoppingAllTheRestFirst = maxCoins(nums, dp, first, i-1)+maxCoins(nums, dp, i+1, last);
            ans = Integer.max(ans, coinsGainedAfterPoppingAllTheRestFirst+coinsGainedAfterPoppingIthInEnd);
        }
        dp[first][last] = ans;
        return ans;
    }
}