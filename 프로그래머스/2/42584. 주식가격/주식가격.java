import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length-1; i++) {
            int cnt = 0;
            for(int k=i+1; k<prices.length; k++){
                if(prices[i] <= prices[k]){
                    cnt++;
                }else{
                    cnt++;
                    break;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }
}