import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static Map<Integer, List<int[]>> map;

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());
        map = new HashMap<>();
        for(int i = 1; i<=N; i++){
            map.putIfAbsent(i, new ArrayList<>());
        }
        for(int i = 1; i <=M; i++){
            st = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(from, k->new ArrayList<>()).add(new int[]{to, cost});
        }
        st = new StringTokenizer(input.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        System.out.println(Dijkstra(start, target));


    }

    public static int Dijkstra(int start, int end){
        int[] distance = new int[N+1];
        for(int i = 1; i<=N; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0, start});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int current_weight = current[0], current_node = current[1];
            if(current_weight > distance[current_node]) continue;
            for(int[] info : map.get(current_node)){
                int weight = info[1], node = info[0];
                int new_distance = weight + current_weight;
                if(new_distance < distance[node]){
                    distance[node] = new_distance;
                    pq.add(new int[]{new_distance, node});
                }
            }
        }

        return distance[end];
    }
}