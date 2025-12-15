import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][][] dp = new int[n][n][3];
        boolean[][] wall = new boolean[n][n];
        for(int i = 0; i<n; i++) {
            String[] tmp = br.readLine().split(" ");
            for(int k = 0; k<n; k++) {
                if(Integer.parseInt(tmp[k]) == 1) wall[i][k] = true;
            }
        }
        dp[0][1][0] = 1; //  첫 시작은 (0,0), (0,1)에 가로로 되어있음, 어차피 (0,0)은 갈수도 없으니 제외
        for(int y = 0; y<n; y++){
            for(int x = 0; x<n; x++){
                if(!wall[y][x]){
                    if(x>0){ // 가로
                        // 파이프가 가로로 있을때, →, ↘만 가능
                        // 단 →으로 밀었을때 벽이면 안됨
                        dp[y][x][0] += dp[y][x-1][0];
                        dp[y][x][0] += dp[y][x-1][2];
                    }
                    if(y>0){ // 세로
                        // 파이프가 세로로 있을때, ↓, ↘만 가능
                        // 단 ↓으로 밀었을때 벽이면 안됨
                        dp[y][x][1] += dp[y-1][x][1];
                        dp[y][x][1] += dp[y-1][x][2];
                    }
                    if(x>0 && y>0 && !wall[y-1][x] && !wall[y][x-1]){ // 대각선
                        // 파이프가 대각선으로 있을때, →, ↓, ↘ 가능
                        // 단 →, ↓으로 밀었을때 벽이면 안됨
                        dp[y][x][2] += dp[y-1][x-1][2];
                        dp[y][x][2] += dp[y-1][x-1][0];
                        dp[y][x][2] += dp[y-1][x-1][1];
                    }
                }
            }
        }
        System.out.println(Arrays.stream(dp[n-1][n-1]).sum());
    }
}