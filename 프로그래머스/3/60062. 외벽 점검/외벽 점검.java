import java.util.*;

class Solution {
    private static int[] weak_double;
    private static boolean[] used;
    private static int answer, weak_length;

    private static boolean check(int[] friends){

        for(int i=0; i<weak_length; i++){
            int idx = i;
            for(int guy : friends){
                int position = weak_double[idx++] + guy;
                while(idx < weak_double.length && weak_double[idx] <= position){
                    idx++;
                }
            }
            if(idx - i >= weak_length){
                return true;
            }
        }
        return false;
    }

    private static void backTrack(int n, int[] dist, int[] org){
        if(org.length == n){
            if(check(dist)) answer = n;
            return;
        }

        for(int i=0; i<org.length; i++){
            if(used[i]) continue;
            used[i] = true;
            dist[n] = org[i];
            backTrack(n+1, dist, org);
            used[i] = false;
        }


    }
    public int solution(int n, int[] weak, int[] dist) {
        weak_length = weak.length;
        used = new boolean[dist.length];
        weak_double = new int[weak_length * 2];
        answer = -1;
        for(int i=0; i<2; i++){
            for (int k =0; k < weak_length; k++){
                weak_double[k + (i * weak_length)] = weak[k] + (i * n);
            }
        }
        Arrays.sort(weak_double);

        for(int i=1; i<=dist.length; i++){
            int[] org = new int[i];
            System.arraycopy(dist, dist.length - i, org, 0, i);
            backTrack(0, new int[i], org);
            if(answer>0){
                break;
            }
        }
        return answer;
    }
}