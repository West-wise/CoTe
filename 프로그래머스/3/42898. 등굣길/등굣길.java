import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        boolean[][] water = new boolean[n][m];
        dp[0][0] = 1;
        for(int[] puddle : puddles){
            int x = puddle[0] - 1;
            int y= puddle[1] - 1;
            if(y>=0 && y<n && x >= 0 && x<m){
                water[y][x] = true;
            }
        }
        for(int y = 0; y<n; y++){
            for(int x = 0; x<m; x++){
                if(x==0 && y==0) continue;
                if(water[y][x]){
                    dp[y][x] = 0;
                    continue;
                }
                if(y>0) dp[y][x] = (dp[y-1][x] + dp[y][x]) % 1000000007;
                if(x>0) dp[y][x] = (dp[y][x] + dp[y][x-1]) % 1000000007;
            }
        }
        return dp[n - 1][m - 1];
    }
}