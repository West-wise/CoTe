import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long to_int = Long.parseLong(p);
        int p_len = p.length();
        int t_len = t.length();
        for(int i = 0; i <= t_len - p_len + 1; i++){
            try{
                if(Long.parseLong(t.substring(i,i + p_len))<=to_int) answer++;    
            } catch(Exception e){
                continue;
            }
        }
        return answer;
    }
}