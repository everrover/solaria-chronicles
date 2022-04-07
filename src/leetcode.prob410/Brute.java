package leetcode.prob410;// Std imports

class Brute {
    private static int []sums;
    public int splitArray(int[] nums, int m) {
        sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i=1; i<sums.length; i++){
            sums[i] = sums[i-1]+nums[i];
        }
        return utils(nums, m, 0);
    }
    
    private int utils(int nums[], int m, int idx){
        int sumAtIdx = idx == 0? 0: sums[idx-1];
        if(m==1) {
            return sums[sums.length-1]-sumAtIdx;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=idx; i<=(nums.length-m); i++){
            int sol = Integer.max(sums[i]-sumAtIdx, utils(nums, m-1, i+1));
            ans = Integer.min(ans, sol);
        }
        return ans;
    }
}
