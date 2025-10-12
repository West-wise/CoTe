import java.util.*;
class Solution {
    private int bfs(int[][] maps, boolean[][] visited, int[] start){
        int rows = maps.length, cols = maps[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0], y = current[1], cost = current[2];
            if(x == rows-1 && y == cols -1) return cost;
            for(int[] dir : directions){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && nx < rows && ny>=0 && ny < cols && !visited[nx][ny] && maps[nx][ny] != 0){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cost+1});
                }
            }
        }
        return -1;
    }
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        return bfs(maps, visited, new int[]{0,0,1});
    }
}