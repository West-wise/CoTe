import java.util.*;

class Solution {
    public int BFS(String[] graph, int[] start, char target){
        // 최단 경로를 찾아야하기 때문에 BFS
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
        int rows = graph.length, cols = graph[0].length();
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0],start[1],0});
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0], y = current[1], cost = current[2];
            if(graph[x].charAt(y) == target ){return cost;}
            for(int[] dir : directions){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny] && graph[nx].charAt(ny) != 'X'){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny,cost+1});
                }
            }
        }
        return -1;
    }
    public int[] findCoordinate(String[] graph, char target){
        int[] answer = new int[2];
        for(int i=0; i<graph.length; i++){
            for(int k=0; k<graph[0].length(); k++){
                if(graph[i].charAt(k) == target){
                    answer[0] = i;
                    answer[1] = k;
                    return answer;
                }
            }
        }
        return answer;
    }
    public int solution(String[] maps) {
        int[] start = findCoordinate(maps, 'S');
        int[] lever = findCoordinate(maps, 'L');

        int toLever = BFS(maps,start, 'L');
        if(toLever == -1){return -1;}
        int toEnd = BFS(maps,lever, 'E');
        if(toEnd == -1){return -1;}
        return toLever + toEnd;
    }
}