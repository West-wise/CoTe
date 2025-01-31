import java.util.*;

class Solution {


    public int dijkstra(int[][] board){
        int rows = board.length, cols = board[0].length;
        int[][][] costMap = new int[rows][cols][4];
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        for(int[][] arr : costMap){
            for(int[] sub : arr){
                Arrays.fill(sub,Integer.MAX_VALUE);
            }
        } // 다익스트라를 위해서 무한대로 채우기
//        costMap[0][0][0] = 0; // 맨 처음은 0으로 변경
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2])); // cost를 기준으로 오름차순 정렬하는 우선순위 큐 설정
        pq.add(new int[]{0,0,0,-1}); // x, y, cost, preDir지정

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int x = current[0], y = current[1], cost = current[2], preDir = current[3];
            if(x == rows - 1 && y == cols - 1){return cost;}
            for(int d=0; d<4; d++){
                int nx = x + directions[d][0], ny= y + directions[d][1];
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && board[nx][ny] == 0){
                    int newCost = cost + 100;
                    if(preDir != -1 && preDir != d){
                        newCost += 500;
                    }
                    if(newCost < costMap[nx][ny][d]){
                        costMap[nx][ny][d] = newCost;
                        pq.add(new int[]{nx, ny, newCost, d});
                    }
                }
            }
        }
        return -1;
    }
    public int solution(int[][] board) {
        return dijkstra(board);
    }
}