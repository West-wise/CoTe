import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<=n;i++){
            if(i<=1) al.add(i);
            else {
                al.add((al.get(i-1)+al.get(i-2))%1234567);
            }
        }
        return al.get(n);
    }
}