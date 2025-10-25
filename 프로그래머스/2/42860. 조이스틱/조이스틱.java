import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] array = name.toCharArray();
        // 상, 하 최적 이동 횟수
        for(int i = 0; i < array.length; i++) {
            if(array[i] == 'A') continue;
            answer += Math.min((array[i] - 'A'), ('Z' - array[i] + 1));
        }

        // 좌, 우 이동 최적값
        int len = array.length;
        int move = len - 1;
        for(int i = 0; i<len; i++){
            int next = i + 1;
            while(next < len && array[next] == 'A'){
                next++;
            }
            move = Math.min(move, i + len - next + Math.min(i, len-next));
        }
        answer += move;
        return answer;
    }
}