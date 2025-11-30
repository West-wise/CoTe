import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int t_len = triangle.length-1;
        int[] dp = Arrays.copyOf(triangle[t_len], triangle[t_len].length);
        for(int i = t_len-1; i>=0; i--){
            for(int k = 0; k<triangle[i].length; k++){
                dp[k] = Math.max(dp[k], dp[k+1]) + triangle[i][k];
            }
        }
        return dp[0];
    }
}
