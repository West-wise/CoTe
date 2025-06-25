import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, K;
    public static List<List<int[]>> graph;
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i = 0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i =0; i<M; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b,c}); // 그냥 map과 같은 형태이지만 인덱스를 이용한 탐색을 더 빠르게 하기 위해 List<List<int[]>>를 사용
        }

        PriorityQueue<Integer>[] dist = new PriorityQueue[N+1]; // [List, List, List, List .... ]
        for(int i = 0; i<=N; i++){
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }
        Dijkstra(dist);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if(dist[i].size() < K) sb.append("-1\n");
            else {
                sb.append(dist[i].peek()).append("\n");
            }
        }
        System.out.println(sb);

    }

    public static void Dijkstra(PriorityQueue<Integer>[] dist){
        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.add(new Path(1,0));
        dist[1].add(0);

        while(!pq.isEmpty()){
            Path currentPath = pq.poll();
            int currentCost = currentPath.cost;
            int currentNode = currentPath.node;
            List<int[]> neighbor = graph.get(currentNode);

            for(int[] next : neighbor){
                int nextCost = next[1] + currentCost;
                int nextNode = next[0];
                if(dist[nextNode].size() < K){ // 이거의 의미는...., 아 특정 노드로 가는 거리를 저장...
                    // 이게 각 인덱스가 n번째 다익스트라의 모든 경로를 저장하는게 아니라 각 노드로 가는 n개의 경로를 저장하는 거구나
                    dist[nextNode].add(nextCost);
                    pq.add(new Path(nextNode, nextCost));
                }else if(dist[nextNode].peek() > nextCost){ // K개보다 많이 저장되어있으면 새로 추가되는 값보다 큰값이 있으면 제거하고 새로운 값을 추가
                    dist[nextNode].poll();
                    dist[nextNode].add(nextCost);
                    pq.add(new Path(nextNode, nextCost));
                }

            }
        }
    }


    static class Path implements Comparable<Path> {
        int node, cost;
        Path(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Path path){
            return Integer.compare(this.cost, path.cost);
        } // PriorityQueue를 사용하기 위한 우선순위 조건 설정, cost를 기준으로 설정
    }
}