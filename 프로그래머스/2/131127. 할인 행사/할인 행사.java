import java.util.*;

class Solution {
    public boolean windowCheck(Map<String, Integer> map, String[] want, int[] number){
        for(String goods : want){ // 원하는 상품이 없다면?
            if(!map.containsKey(goods))  return false;
        }

        //원하는 상품은 다 있는데 갯수가 부족하다면?
        for(int i=0; i<want.length; i++){
            if(map.get(want[i]) != number[i]) return false;
        }

        return true;
    }
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>() , window = new HashMap<>();
        int answer = 0;

        for(int i=0; i<want.length; i++) {
            map.put(want[i],number[i]);
        }
        // 첫번째 윈도우
        for(int i=0; i<10; i++){
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }
        if(windowCheck(window, want, number)) answer++;


        for(int i = 10; i<discount.length; i++) {
            // 오래된 부분 제거
            String remove = discount[i-10];
            window.put(remove, window.get(remove) - 1);
            if(window.get(remove) == 0){
                window.remove(remove);
            }
            String newItem = discount[i];
            window.put(newItem, window.getOrDefault(newItem, 0) + 1);
            if (windowCheck(window, want, number)) answer++;

        }


        return answer;
    }
}