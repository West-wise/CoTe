import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static Map<Integer, List<int[]>> map;

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for(int i = 1; i<=N; i++){
            map.putIfAbsent(i, new ArrayList<>());
        }

        int start = Integer.parseInt(input.readLine());
        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map.get(from).add(new int[]{to, cost});
        }

        int[] res = Dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N; i++){
            if(res[i] == Integer.MAX_VALUE){
                sb.append("INF\n");
            } else if(res[i] == 0){
                sb.append("0\n");
            } else{
                sb.append(res[i]).append("\n");
            }
        }
        System.out.println(sb);

    }

    public static int[] Dijkstra(int start){
        int[] dist = new int[N+1]; // 인덱스가 노드, 값이 코스트
        for(int i = 1; i <= N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0, start});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int current_weight = current[0], current_node = current[1];
            if(current_weight < dist[current_node]) continue;
            for(int[] node_list : map.get(current_node)){
                int weight = node_list[1], new_node = node_list[0];
                int new_weight = weight + current_weight;
                if(new_weight < dist[new_node]){
                    dist[new_node] = new_weight;
                    pq.add(new int[]{new_weight, new_node});
                }
            }
        }
        return dist;
    }
}