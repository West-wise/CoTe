import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 최대 2명만 태울수 있다.

        Arrays.sort(people);  // 오름차순 정렬
        Deque<Integer> dq = new LinkedList<>();
        for (int num : people) {
            dq.add(num);
        }
        while(dq.size()>=2){
            int left=dq.peek();
            int right=dq.getLast();
            if(left+right <= limit){
                dq.removeFirst();
            }
            dq.removeLast();
            answer++;
        }
        if(!dq.isEmpty()){
            answer++;
        }
        return answer;
    }
}