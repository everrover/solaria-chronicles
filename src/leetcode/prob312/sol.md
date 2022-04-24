# Popping balloons and receiving coins

## The solution that works isn't very intuitive

The trick is to think backwards. Instead of trying to pop a balloon in the beginning, we must try to pop the balloon in the end.

I had to reverse engineer a working solution to understand it completely. 

Here's the code. Please note, I have not used sentinel values.

```java
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
            // Statement 1
            int coinsGainedAfterPoppingIthInEnd = (first>0?nums[first-1]:1)*nums[i]*(last<(nums.length-1)?nums[last+1]:1);
            // Statement 2
            int coinsGainedAfterPoppingAllTheRestFirst = maxCoins(nums, dp, first, i-1)+maxCoins(nums, dp, i+1, last);
            ans = Integer.max(ans, coinsGainedAfterPoppingAllTheRestFirst+coinsGainedAfterPoppingIthInEnd);
        }
        dp[first][last] = ans;
        return ans;
    }
}
```

Statement 1: We multiply `nums[first-1]` and `nums[last+1]` because we are assuming that the `i` element will be the next popped element after first and last.

As a summary, tThe recursive statement is as follows,
```
S(f,l) = max(nums[f-1]*nums[i]*nums[l+1] + S(f, i-1) + S(i+1, l)),  n > i >= 0 && f <= l
       = 0, f>l
```

Cheers guyz.