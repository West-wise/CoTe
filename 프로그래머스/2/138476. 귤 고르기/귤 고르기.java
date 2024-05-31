import java.util.*;


class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : tangerine){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        
        int sum = 0;
        for(Integer i : map.keySet()){
            list.add(map.get(i));
        }
        
        list.sort(Collections.reverseOrder());
        
        for(Integer i : list){
            answer++;
            sum += i;
            if(sum>=k)break;
        }
        return answer;
    }
}