import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        int[] dday = new int[progresses.length];
        for(int i=0; i<progresses.length; i++) {
            dday[i] = (int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }
        Arrays.stream(dday).forEach(queue::add);

        int cnt =0;
        int MaxDay = dday[0];
        for(int i=0; i<progresses.length; i++) {
            if(dday[i] <= MaxDay){
                cnt++;
            } else {
                res.add(cnt);
                cnt = 1;
                MaxDay = dday[i];
            }
        }
        res.add(cnt);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}