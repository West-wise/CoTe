import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int sat = (6 - startday + 7) % 7;
        int sun = (7 - startday + 7) % 7;

        Map<Integer,Integer> humans = new HashMap<>();
        for(int i=0;i<schedules.length;i++){
            humans.put(i,0);
        }
        int[] nSchedules = new int[schedules.length];
        for(int i=0; i<schedules.length; i++){
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100;
            if(minute + 10 >= 60){
                hour++;
                minute -= 50;
            } else{
                minute += 10;
            }
            nSchedules[i] = (hour*100) + minute;
        }

        for(int i=0; i<schedules.length; i++){
            for(int k=0; k<7; k++){
                if(k == sat || k == sun) continue;
                if(nSchedules[i] - timelogs[i][k] >= 0){
                    humans.merge(i, 1, Integer::sum);
                }
            }
        }
        int answer = 0;
        for(int key : humans.values()){
            if(key==5) answer++;
        }

        return answer;
    }
}