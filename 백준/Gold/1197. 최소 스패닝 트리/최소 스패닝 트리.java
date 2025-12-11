import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int from;
    int to;
    long cost;
    public Edge(int from,int to, long cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(cost, o.cost);
    }
}
public class Main {
    private static int find(int[] parent, int node){
        if(parent[node] == node) return node;
        return parent[node] = find(parent, parent[node]);
    }
    private static void union(int[] parent, int[] size, int nodeA, int nodeB){
        int rootA = find(parent, nodeA);
        int rootB = find(parent, nodeB);
        if(rootA == rootB) return;
        if(size[rootA] < size[rootB]){
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int[] parent = new int[V+1];
        int[] size = new int[V+1];
        long answer = 0;
        int cnt = 0;
        Arrays.fill(size,1);
        for(int i = 0; i<=V; i++) parent[i] = i;
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i<E; i++){
            int[] val = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(new Edge(val[0], val[1],val[2]));
        }
        Collections.sort(edges);

        for(Edge e : edges){
            if(find(parent,e.from)!=find(parent,e.to)){
                union(parent,size, e.from,e.to);
                answer+=e.cost;
                if(++cnt == V-1) break;
            }
        }
        System.out.println(answer);
    }
}