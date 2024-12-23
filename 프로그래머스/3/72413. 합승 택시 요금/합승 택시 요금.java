import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    static class Edge{
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    static List<List<Edge>> createGraph(int[][] edges, int n){
        List<List<Edge>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            graph.get(from).add(new Edge(to, weight));
            graph.get(to).add(new Edge(from, weight));
        }

        return graph;
    }

    static int[] Dijkstra(List<List<Edge>> graph, int src, int num){
        int[] distance = new int[num+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        pq.offer(new Edge(src,0));

        boolean[] visited = new boolean[num+1];

        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int currentNode = current.target;
            if (visited[currentNode]) continue; //이미 방문한 노드이면 패스
            visited[currentNode] = true;
            // pq는 우선순위 큐로써 현재 src부터해서
            for(Edge neighbor : graph.get(currentNode)){
                int nextNode = neighbor.target;
                int newDistance = neighbor.weight + distance[currentNode];

                if(newDistance < distance[nextNode]){
                    distance[nextNode] = newDistance;
                    pq.offer(new Edge(nextNode, newDistance));
                }
            }
        }

        return distance;
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        // start = s;
        // end a = a;
        // end b = b;
        List<List<Edge>> graph = createGraph(fares, n);

        // 시작노드에서 가장 가까운 노드들을 탐색한다.
        int[] fromStart = Dijkstra(graph, s, n);
        int[] fromA = Dijkstra(graph, a, n);
        int[] fromB = Dijkstra(graph, b, n);

        int minCost = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            if(fromStart[i] == Integer.MAX_VALUE || fromA[i] == Integer.MAX_VALUE || fromB[i] == Integer.MAX_VALUE){
                continue;
            }
            int CostViaI = fromStart[i] + fromA[i] + fromB[i];
            minCost = Math.min(minCost, CostViaI);
        }
        return minCost;
    }
}