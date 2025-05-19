import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int target;
    int cost;
    public Node(int target, int cost){
        this.target = target;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other){
        return Integer.compare(this.cost, other.cost);
    }
}
public class Main {
    public static int N, M,K,X;
    public static final int INF = Integer.MAX_VALUE;
    public static int[] dist;
    public static void Dijkstra(int start, Map<Integer,List<Node>> map){
        dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start,0));
        while(!queue.isEmpty()){
            Node current_node = queue.poll();
            if(current_node.cost > dist[current_node.target]) continue;
            List<Node> neighbor = map.get(current_node.target);
            if(neighbor == null) continue;
            for(Node next : neighbor){
                int newDist = dist[current_node.target] + next.cost;
                if(newDist < dist[next.target]){
                    dist[next.target] = newDist;
                    queue.offer(new Node(next.target, newDist));
                }
            }

        }

    }
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        Map<Integer, List<Node>> map = new HashMap<>();
        boolean[] visited = new boolean[N+1];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(start, k -> new ArrayList<>()).add(new Node(target, 1));
//            map.computeIfAbsent(target, k-> new ArrayList<>()). add(new Node(start,1));
        }

        Dijkstra(X, map);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i< dist.length; i++){
            if(dist[i] == K) result.add(i);
        }
        if(result.isEmpty()){
            System.out.println(-1);
        } else{
            Collections.sort(result);
            StringBuilder sb = new StringBuilder();
            for(int num : result){
                sb.append(num).append("\n");
            }
            System.out.println(sb.toString());
        }

    }
}