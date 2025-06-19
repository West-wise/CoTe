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

        Map<Integer, Integer> res = Dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N; i++){
            if(res.get(i) == Integer.MAX_VALUE){
                sb.append("INF\n");
            } else if(res.get(i) == 0){
                sb.append("0\n");
            } else{
                sb.append(res.get(i)).append("\n");
            }
        }
        System.out.println(sb.toString());

    }

    public static Map<Integer, Integer> Dijkstra(int start){
        Map<Integer, Integer> distance = new HashMap<>();
        for(int i =1; i<=N; i++){
            distance.put(i, Integer.MAX_VALUE); // 가중치 최대값이 10이기 때문에 그냥 11로 퉁치자
        }
        distance.put(start, 0); // 시작 노드만 0으로 변경

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        queue.add(new int[]{0, start});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int current_weight = current[0], current_node = current[1];
            if(current_weight > distance.get(current_node)) continue;
            for(int[] tuple : map.get(current_node)){
                int weight = tuple[1], node = tuple[0];
                int new_dist = weight + current_weight;
                if(new_dist < distance.get(node)){
                    distance.put(node, new_dist);
                    queue.add(new int[]{new_dist, node});
                }
            }

        }
        return distance;
    }
}