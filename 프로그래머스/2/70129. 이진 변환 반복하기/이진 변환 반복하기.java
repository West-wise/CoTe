import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] zero = new int[2];
        for(int i=0; i<s.length()*3; i++) {
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                if(c == '1') {
                    sb.append(c);
                } else {
                    zero[1]++;
                }
            }
            s = Integer.toBinaryString(sb.length());
            zero[0]++;
            if(s.equals("1")) return zero;
        }
        return zero;
    }
}