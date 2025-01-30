import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        // 프림 알고리즘 사용
        Map<Integer,List<int[]>> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // cost를 기준으로 오름차순 정렬
        Set<Integer> visited = new HashSet<>();

        for(int[] cost : costs){
            int start = cost[0], next = cost[1], weight = cost[2];
            map.computeIfAbsent(start, k -> new ArrayList<>()).add(new int[]{next, weight});
            map.computeIfAbsent(next, k -> new ArrayList<>()).add(new int[]{start, weight});
        }
        pq.add(new int[]{0,0}); // 시작노드 설정

        while(!pq.isEmpty() && visited.size() < n){
            int[] cur = pq.poll();
            int node = cur[0], cost = cur[1];
            if(visited.contains(node)) continue;
            visited.add(node);
            answer += cost;
            for(int[] neighbor : map.get(node)){
                int neighbor_node = neighbor[0], neighbor_cost = neighbor[1];
                if(!visited.contains(neighbor_node)){
                    pq.add(new int[]{neighbor_node, neighbor_cost});
                }
            }
        }
        return answer;
    }
}