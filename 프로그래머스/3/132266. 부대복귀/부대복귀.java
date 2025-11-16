import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int num = sources.length;
        int[] answer = new int[num];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        int[] dist = new int[n+1]; // 0은 사용하지 않음,
        Arrays.fill(dist, -1);
        dist[destination] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(destination);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int next : graph.get(node)){
                if(dist[next] == -1){
                    queue.add(next);
                    dist[next] = dist[node] + 1;
                }
            }
        }
        for(int i = 0; i<num; i++){
            int s = sources[i];
            if(s >= 0 && s <= n) answer[i] = dist[s];
            else answer[i] = -1;
        }

        return answer;
    }
}