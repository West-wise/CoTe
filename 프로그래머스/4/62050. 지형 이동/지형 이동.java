import java.util.*;
class Solution {
    private static class Node{
        int x,y,cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    public int solution(int[][] land, int height) {
        int answer = 0;
        int rows = land.length, cols = land[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<int[]> ladder = new PriorityQueue<>(Comparator.comparingInt(array -> array[2]));
        PriorityQueue<Node> nodeQ = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));

        nodeQ.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while(!nodeQ.isEmpty()){
            Node node = nodeQ.poll();
            int x = node.x, y = node.y, cost = node.cost;
            for(int[] dir : directions){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]){
                    int diff = Math.abs(land[x][y] - land[nx][ny]);
                    if(diff <= height){
                        visited[nx][ny] = true;
                        nodeQ.add(new Node(nx, ny, cost));
                    } else {
                        ladder.add(new int[]{nx, ny, diff});
                    }
                }
            }

            while(!ladder.isEmpty() || !nodeQ.isEmpty()){
                if(!nodeQ.isEmpty()) break;
                int[] tmp = ladder.poll();
                int nx = tmp[0], ny = tmp[1], diff = tmp[2];
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                answer += diff;
                nodeQ.add(new Node(nx, ny, 0));
            }
        }
        return answer;
    }
}