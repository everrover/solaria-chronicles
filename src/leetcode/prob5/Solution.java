package leetcode.prob5;

class Solution {
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        final int m = chs.length;
        int ml = 0, i = 0;
        String sol = "";
        // expansion around centre
        while(i<m){
            int j=i, k=i;
            while(j>=0 && k<m && chs[j] == chs[k]){
                j--; k++;
            }
            if((k-j+1) > ml){
                ml = j-k+1;
                sol = s.substring(j+1, k);
            }
            if((i+1)<m&&chs[i]==chs[i+1]){
                while(j>=0 && k<m && chs[j] == chs[k]){
                    j--; k++;
                }
                if((k-j+1) > ml){
                    ml = j-k+1;
                    sol = s.substring(j+1, k);
                }
            }
            i++;
        }
        return sol;
        // dp
    }
}