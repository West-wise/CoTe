import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        List<Integer> answer = new ArrayList<>();
        int[] uni = my_string.chars().toArray();
        for( int ch : uni){
            if(ch >= '0' && ch <= '9'){
                answer.add(ch - '0');
            }
        }
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}