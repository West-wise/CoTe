import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int[] list = Arrays.stream(d).sorted().toArray();
        
        for(int i = 0; i<list.length; i++){
            if(budget >= list[i]){
                answer++;
                budget -= list[i];
            } else {
                break;
            }
        }
        return answer;
    }
}