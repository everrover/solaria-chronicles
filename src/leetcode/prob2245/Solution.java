package leetcode.prob2245;

class Solution {
    private static int twoCounts[], fiveCounts[];
    public int maxTrailingZeros(int[][] grid) {
        // int twoCounts[], fiveCounts[];
        //            twoCounts = new int[1001]; fiveCounts = new int[1001];

        if(twoCounts == null || fiveCounts == null){
            twoCounts = new int[1001]; fiveCounts = new int[1001];
            twoCounts[2] = 1;
            fiveCounts[5] = 1;
            for(int i=4; i<=1000; i++){
                if(i%2==0){
                    twoCounts[i] = twoCounts[i/2]+1;
                }
                if(i%5==0){
                    fiveCounts[i] = fiveCounts[i/5]+1;
                }
            }
        }
        final int m = grid.length, n = grid[0].length;
        int twoT[][] = new int[m][n], twoB[][] = new int[m][n], twoL[][] = new int[m][n], twoR[][] = new int[m][n];
        int fiveT[][] = new int[m][n], fiveB[][] = new int[m][n], fiveL[][] = new int[m][n], fiveR[][] = new int[m][n];
        for(int i=0; i<m; i++){
            twoL[i][0] = twoCounts[grid[i][0]];
            fiveL[i][0] = fiveCounts[grid[i][0]];
            for(int j=1; j<n; j++){
                fiveL[i][j] = fiveCounts[grid[i][j]]+fiveL[i][j-1];
                twoL[i][j] = twoCounts[grid[i][j]]+twoL[i][j-1];
            }
            twoR[i][n-1] = twoCounts[grid[i][n-1]];
            fiveR[i][n-1] = fiveCounts[grid[i][n-1]];
            for(int j=n-2; j>=0; j--){
                fiveR[i][j] = fiveCounts[grid[i][j]]+fiveR[i][j+1];
                twoR[i][j] = twoCounts[grid[i][j]]+twoR[i][j+1];
            }
        }
        for(int j=0; j<n; j++){
            twoT[0][j] = twoCounts[grid[0][j]];
            fiveT[0][j] = fiveCounts[grid[0][j]];
            for(int i=1; i<m; i++){
                fiveT[i][j] = fiveCounts[grid[i][j]]+fiveT[i-1][j];
                twoT[i][j] = twoCounts[grid[i][j]]+twoT[i-1][j];
            }
            twoB[m-1][j] = twoCounts[grid[m-1][j]];
            fiveB[m-1][j] = fiveCounts[grid[m-1][j]];
            for(int i=m-2; i>=0; i--){
                fiveB[i][j] = fiveCounts[grid[i][j]]+fiveB[i+1][j];
                twoB[i][j] = twoCounts[grid[i][j]]+twoB[i+1][j];
            }
        }
        int ans = 0, tmp[][]=new int[m][n];
        for(int i=0; i<m; i++){
            int maxVal = 0;
            for(int j=0; j<n; j++){
                maxVal = Integer.max(maxVal, Integer.min(fiveT[i][j]+((j<(n-1))?fiveR[i][j+1]:0), twoT[i][j]+((j<(n-1))?twoR[i][j+1]:0)));
                maxVal = Integer.max(maxVal, Integer.min(fiveB[i][j]+((j<(n-1))?fiveR[i][j+1]:0), twoB[i][j]+((j<(n-1))?twoR[i][j+1]:0)));
                maxVal = Integer.max(maxVal,
                        Integer.min(fiveT[i][j]+((j>0)?fiveL[i][j-1]:0),
                                twoT[i][j]+((j>0)?twoL[i][j-1]:0)));
                maxVal = Integer.max(maxVal, Integer.min(fiveB[i][j]+((j>0)?fiveL[i][j-1]:0), twoB[i][j]+((j>0)?twoL[i][j-1]:0)));
            }
            ans = Integer.max(ans, maxVal);
        }
        return ans;
    }
}