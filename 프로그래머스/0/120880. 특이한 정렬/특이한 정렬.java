import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        Integer[] list = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        Arrays.sort(list, (a,b) -> {
            int diffA = Math.abs((a - n));
            int diffB = Math.abs(b - n);
            return diffA != diffB ? diffA - diffB : b - a;
        });
        return Arrays.stream(list).mapToInt(a->a).toArray();
    }
}