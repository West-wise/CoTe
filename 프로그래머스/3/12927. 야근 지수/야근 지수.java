import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            pq.add((long) work);
        }

        for(int i = 0; i<n; i++){
            int pop = Math.toIntExact(pq.poll());
            if(pop <= 0) break;
            pq.add((long) (pop-1));
        }
        while(!pq.isEmpty()){
            answer+= (long) Math.pow(pq.poll(),2);
        }

        return answer;
    }
}