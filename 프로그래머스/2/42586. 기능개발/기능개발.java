import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] dday = new int[progresses.length];

        for(int i=0; i<progresses.length; i++) {
            dday[i] = (int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }

        int cnt = 0;
        int MaxDay = dday[0];

        for(int i=0; i<progresses.length; i++) {
            if(dday[i] <= MaxDay) {
                cnt++;
            } else{
                answer.add(cnt);
                MaxDay = dday[i];
                cnt = 1;
            }
        }
        answer.add(cnt);

        return answer.stream().mapToInt(i->i).toArray();
    }
}