class Solution {
    public int solution(int[] money) {
        int len = money.length;

        int[] dp1 = new int[len];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        // 첫번째 집을 방문하는 경우 원형이라는 조건 때문에 dp[len-1]은 방문하지 못하므루
        // dp1[0] ~ dp1[len-2]
        for(int i = 2; i < len -1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }


        int[] dp2 = new int[len];
        dp2[1] = money[1];
        // 첫번째 집을 방문하지 않는 경우는 dp2[len-1]을 방문 가능
        // dp2[1] ~ dp[len-1]
        for(int i = 2; i < len; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }

        return Math.max(dp2[len-1], dp1[len-2]);
    }
}