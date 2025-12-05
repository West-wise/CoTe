import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(reserve);
        Arrays.sort(lost);
        Set<Integer> need = new HashSet<>();
        Set<Integer> extra = new HashSet<>();
        for(int i : reserve) extra.add(i);
        for(int i : lost) {
            if(extra.contains(i)) extra.remove(i); // 여별옷 가져와놓고 도둑맞은 사람
            else need.add(i);
        }
        int answer = n - need.size();

        for(int i : new TreeSet<>(extra)) {
            if(need.contains(i-1)){
                answer++;
                need.remove(i-1);
            } else if(need.contains(i+1)) {
                answer++;
                need.remove(i+1);
            }
        }
        return answer;
    }
}