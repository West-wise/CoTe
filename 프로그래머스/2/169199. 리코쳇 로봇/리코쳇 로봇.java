import java.util.*;
class Solution {

    public int BFS(String[] board, int[] start, int[] goal){
        int rows = board.length, cols = board[0].length();
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start[0], start[1], 0}); // 시작점과 거리(0)
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];
            if(x==goal[0] && y==goal[1]){return dist;}

            for(int[] dir : directions){
                int nx = x, ny = y;
                while(true){
                    nx += dir[0];
                    ny += dir[1];
                    if(nx < 0 || nx >= rows || ny < 0 || ny >= cols || board[nx].charAt(ny) == 'D'){
                        nx -= dir[0];
                        ny -= dir[1];
                        break;
                    }
                }
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist+1});
                }
            }
        }
        return -1;
    }
    public int[] findPost(String[] map, char target){
        for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < map[i].length(); k++) {
                if(map[i].charAt(k) == target){ return new int[]{i, k};}
            }
        }
        return new int[]{-1, -1};
    }

    public int solution(String[] board) {
        int[] start = findPost(board, 'R');
        int[] goal = findPost(board, 'G');
        return BFS(board, start, goal);
    }
}