import java.util.*;
class Solution {
    public int solution(String[] strs, String t) {
        Set<String> set  = new HashSet<>();
        set.addAll(Arrays.asList(strs));
        int[] count = new int[t.length()+1];
        Arrays.fill(count, 20000);
        count[0] = 0;
        for(int i = 1; i <= t.length(); i++){
            for(int k = Math.max(0,i-5); k < i; k++){
                if(set.contains(t.substring(k,i))){
                    count[i] = Math.min(count[i],count[k]+1);
                }

            }
        }
        return count[t.length()] == 20000 ? -1 : count[t.length()];
    }
}