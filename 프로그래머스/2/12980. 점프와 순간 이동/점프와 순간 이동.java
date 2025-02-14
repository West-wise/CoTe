import java.util.*;

class Solution {
    public int solution(int n) {
        int ans = 0;
        // k칸 앞으로 점프 or 현재까지 온거리 * 2
        while(n > 0){
            if(n % 2 == 0){
                n/=2;
            } else {
                n--;
                ans++;
            }
        }
        return ans;
    }
}