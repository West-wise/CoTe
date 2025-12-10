import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if(n>s) return new int[]{-1};
        int[] answer = new int[n];
        int base = s/n;
        int remain = s%n;
        Arrays.fill(answer,base);
        int lastIdx = n-1;
        for(int i = remain; i>0; i--){
            answer[lastIdx--]++;
        }
        Arrays.sort(answer);
        return answer;
    }
}