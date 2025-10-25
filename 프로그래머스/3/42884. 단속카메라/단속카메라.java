import java.util.*;

class Solution {

    public int solution(int[][] routes) {
        int answer = 0;
        int lastPos = -30001;
        Arrays.sort(routes, Comparator.comparingInt(a->a[1]));
        for(int [] arr : routes) {
            if(lastPos < arr[0]){
                lastPos = arr[1];
                answer++;
            }
        }
        return answer;
    }
}