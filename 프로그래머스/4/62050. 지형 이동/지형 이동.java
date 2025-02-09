import java.util.*;
class Solution {
    private static class Node{
        public int x;
        public int y;
        public int cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    private static int getAns(int[][] land, int height){
        int rows = land.length, cols = land[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        PriorityQueue<int[]> ladder = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[2]));

        visited[0][0] = true;
        pq.add(new Node(0,0, 0));
        int ladderCnt = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int x = node.x, y = node.y, cost = node.cost;
            for(int[] dir : directions){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]){
                    int diff = Math.abs(land[x][y] - land[nx][ny]);
                    if(diff <= height){
                        visited[nx][ny] = true;
                        pq.add(new Node(nx, ny, cost));
                    } else {
                        ladder.add(new int[]{nx, ny, diff});
                    }
                }
            }
            while(!pq.isEmpty() || !ladder.isEmpty()){
                if(!pq.isEmpty()) break;
                int[] next = ladder.poll();
                int nx = next[0], ny = next[1], diff = next[2];
                if(visited[nx][ny]) continue;
                ladderCnt += diff;
                visited[nx][ny] = true;
                pq.add(new Node(nx, ny, 0));
            }
        }
        return ladderCnt;
    }

    public int solution(int[][] land, int height) {
        return getAns(land, height);
    }
}