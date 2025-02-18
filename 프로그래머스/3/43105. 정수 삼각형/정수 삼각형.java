class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = triangle;
        for(int i = dp.length-1; i >= 0 ; i--) {
            for(int k = 0; k < dp[i].length-1; k++) {
                dp[i-1][k] = Math.max(triangle[i-1][k] + dp[i][k] , triangle[i-1][k] + dp[i][k+1]);
            }
        }
        return dp[0][0];
    }
}