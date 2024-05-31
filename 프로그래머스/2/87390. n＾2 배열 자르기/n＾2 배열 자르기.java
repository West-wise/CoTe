import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        
        int[] answer = new int[(int)(right-left)+1];

        for(int i=0; i<answer.length; i++){
            int a = (int)(left/n)+1;
            int b = (int)(left%n)+1;
            left++;
            answer[i] = Math.max(a,b);
        }

        return answer;
    }
}