import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        List<String> list = new ArrayList<>();
        for(int num : numbers){
            list.add(String.valueOf(num));
        }
        list.sort((a,b)->{
            int ab = Integer.parseInt(a+b);
            int ba = Integer.parseInt(b+a);
            return Integer.compare(ba,ab);
        });
        for(String num : list){
            answer.append(num);
        }
        return answer.charAt(0) == '0' ? "0" : answer.toString();
    }
}