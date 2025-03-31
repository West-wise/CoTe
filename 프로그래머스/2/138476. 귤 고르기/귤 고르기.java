import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        Map<Integer,Integer> map = new HashMap<>();

        for(int size : tangerine){
            map.put(size,map.computeIfAbsent(size,x -> 0) + 1);
        }
        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((a,b) -> map.get(b) - map.get(a));

        for(int num : keyList){
            k -= map.get(num);
            if(k<=0) break;
            answer++;
        }
        return answer;
    }
}