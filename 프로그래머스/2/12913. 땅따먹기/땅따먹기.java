import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int[][] dp = new int[land.length][];
        for (int i = 0; i < land.length; i++) {
            dp[i] = Arrays.copyOf(land[i], land[i].length);
        }
        for(int i = 0; i < land.length-1; i++){
            for(int k = 0; k < land[i].length; k++){
                for(int j = 0; j < land[i].length; j++){
                    if(k == j) continue;
                    dp[i+1][j] = Math.max(dp[i+1][j],dp[i][k] + land[i+1][j]);
                }
            }
        }
        return Arrays.stream(dp[dp.length-1]).max().getAsInt();
    }
}