import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Map<Integer, List<int[]>> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        for(int[] cost : costs){
            int start = cost[0], end = cost[1];
            map.computeIfAbsent(start, k -> new ArrayList<>()).add(new int[]{end, cost[2]});
            map.computeIfAbsent(end, k-> new ArrayList<>()).add(new int[]{start, cost[2]});
        }
        pq.offer(new int[]{0,0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0], cost = cur[1];
            if(visited[node]) continue;
            visited[node] = true;
            answer+=cost;
            for(int[] neighbor : map.get(node)){
                int n_node = neighbor[0], n_cost = neighbor[1];
                if(!visited[n_node]) pq.offer(new int[]{n_node, n_cost});
            }
        }
        return answer;
    }
}