import java.util.*; 

class Solution {
    static long[] value;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static long answer;
    public long solution(int[] a, int[][] edges){
        graph = new ArrayList<>();
        visited = new boolean[a.length];
        value = new long[a.length];
        answer = 0L;
        int n = a.length;
        for(int i = 0; i< n; i++){
            graph.add(new ArrayList<>());
            value[i] = a[i];
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        deque.push(0);
        while(!deque.isEmpty()){
            int node = deque.peek();
            if(!visited[node]){
                visited[node] = true;
                for(int next : graph.get(node)){
                    if(!visited[next]){
                        deque.push(next);
                        parent[next] = node;
                    }
                }
            } else {
                deque.pop();
                int p = parent[node];
                if(p != -1){
                    long val = value[node];
                    answer += Math.abs(val);
                    value[p] += val;
                }
            }
        }
        if(value[0] != 0) return -1;
        return answer;
    }

}