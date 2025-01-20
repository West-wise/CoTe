import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        // 출발지에서 연결된 모든 노드로 가는 비용의 입력, 양방향으로
        for(int[] cost : costs) {
            graph.computeIfAbsent(cost[0], k-> new ArrayList<>()).add(new int[] {cost[1], cost[2]});
            graph.computeIfAbsent(cost[1], k-> new ArrayList<>()).add(new int[] {cost[0], cost[2]});
        }
        // 프림 알고리즘 사용하기...

        // 우선순위 큐
        //[0] : 출발, [1] : 도착 , [2] : 비용
        // pq에는 현재 방문 가능한 간선의 비용과 연결된 노드가 들어간다
        // 집합에는 방문한 노드 기록
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> visited = new HashSet<>();
        pq.add(new int[]{0, 0}); //시작 노드를 0번 노드로 구성

        while(!pq.isEmpty() && visited.size()<n) {
            int[] current = pq.poll();
            int node = current[0], cost = current[1];

            if(visited.contains(node)) continue; // 이미 방문한 노드 제외
            visited.add(node);
            answer += cost;

            for(int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if(!visited.contains(neighbor[0])){
                    pq.add(new int[]{neighbor[0], neighbor[1]});
                }
            }
        }

        return answer;
    }
}