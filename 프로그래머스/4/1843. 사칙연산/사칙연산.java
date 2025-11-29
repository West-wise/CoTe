import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int num_cnt = arr.length/2 + 1;
        // i번째 피연산자부터 j번째 피연산자까지의 최대값(덧셈, 뺄셈)
        // max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][j] + max_dp[i][k+1]
        // max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][j] - max_dp[i][k+1]
        int[][] max_dp = new int[num_cnt][num_cnt];

        // i번째 피연산자부터 j번째 피연산자까지의 최소값(덧셈, 뺄셈)
        // min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][j] + min_dp[i][k+1]) -> 덧셈 최소
        // min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][j] - min_dp[i][k+1]) -> 뺄셈 최소
        int[][] min_dp = new int[num_cnt][num_cnt];

        for(int i = 0; i<num_cnt; i++){
            Arrays.fill(max_dp[i], Integer.MIN_VALUE);
            Arrays.fill(min_dp[i], Integer.MAX_VALUE);
            max_dp[i][i] = min_dp[i][i] = Integer.parseInt(arr[i*2]);
        }
        for(int len = 1; len<num_cnt; len++){
            for(int i = 0; i<num_cnt-len; i++){
                int j = i + len;
                for(int k = i; k<j; k++){
                    switch(arr[k*2+1]){
                        case "+":
                            max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] + max_dp[k+1][j]);
                            min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] + min_dp[k+1][j]);
                            break;
                        case "-":
                            max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] - min_dp[k+1][j]);
                            min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] - max_dp[k+1][j]);
                    }
                }
            }
        }
        return max_dp[0][num_cnt-1];
    }
}