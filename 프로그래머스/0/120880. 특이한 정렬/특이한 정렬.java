import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = {};
        Integer[] list = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        Arrays.sort(list, (a,b) -> {
            int distA = Math.abs(a-n);
            int distB = Math.abs(b-n);
            return distA != distB ? distA - distB : b - a;
        });
        return Arrays.stream(list).mapToInt(Integer::intValue).toArray();
    }
}