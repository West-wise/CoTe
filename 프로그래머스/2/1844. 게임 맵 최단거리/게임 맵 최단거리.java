import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        // 가장 빠른 경로를 찾아야 하므로 BFS가 아닐까 싶다
        int rows = maps.length, cols = maps[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new ArrayDeque<>();
        visited[0][0] = true;
        queue.add(new int[]{0, 0, 1});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0], y = current[1], cost = current[2];
            if(x == rows - 1 && y == cols -1) return cost;
            for(int[] dir : directions){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny] && maps[nx][ny] != 0){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cost + 1});
                }
            }
        }


        return -1;
    }
}