import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int bfs(int startX, int startY, int[][] board, boolean[][] visited){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY, 1});
        visited[startX][startY] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0],y = current[1];
            if(x == N-1 && y == M-1) return current[2];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i], ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, current[2] + 1});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = input.readLine();
            for(int k = 0; k<M; k++){
                matrix[i][k] = tmp.charAt(k) - '0';
            }
        }
        System.out.println(bfs(0,0,matrix, new boolean[N][M]));
    }
}