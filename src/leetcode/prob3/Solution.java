package leetcode.prob3;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = -1, maxLen = 0;
        final int LEN = s.length();
        boolean []charSet = new boolean[128]; // Can use set if full char range is used, here 'a' <= ch <= 'z'

        while(end<LEN-1){
            int l = (int)s.charAt(start), r= (int)s.charAt(end+1);
            if(charSet[r]){
                charSet[l] = false; start++;
            }else{
                charSet[r] = true; ++end;
                maxLen = Integer.max(end-start+1,maxLen);
            }
        }
        // System.out.println("Used DAT for storing prev indexes");
        return maxLen;
    }

}