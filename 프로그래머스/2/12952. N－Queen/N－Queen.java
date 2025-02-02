import java.util.*;
class Solution {

    public static int N;
    public static boolean[] width;
    public static boolean[] diagonal1;
    public static boolean[] diagonal2;

    public int setQueen(int y) {
        int ans = 0;
        // y는 q의 갯수인듯 하다. ans는 경우의 수이고
        if(y == N){
            ans++;
        } else{
            for(int i = 0; i < N; i++){
                if(width[i] || diagonal1[i+y] || diagonal2[i-y+N]){
                    continue;
                }
                width[i] = diagonal1[i+y] = diagonal2[i-y+N] = true;
                ans += setQueen(y + 1);
                width[i] = diagonal1[i+y] = diagonal2[i-y+N] = false;
            }

        }


        return ans;
    }
    public int solution(int n) {
        int answer = 0;
        // 어차피 한줄에는 하나의 퀸밖에 못놓으니까 이렇게 조합 안만들어도 되려나
        N = n;
        diagonal1 = new boolean[n*2]; // 대각선 /
        diagonal2 = new boolean[n*2]; // 대각선 \
        width = new boolean[n];
        return setQueen(0);
    }
}