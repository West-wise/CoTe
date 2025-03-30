import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0; // 여기는 카운트

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : d){
            pq.add(num);
        }

        for(int i =0; i<d.length; i++){
            int num = pq.poll();
            if (num <= budget){
                answer++;
            }
            budget -= num;
        }
        return answer;
    }
}