import java.util.*;
class Solution {
    public int solution(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }

        int maxDist = Arrays.stream(dist).max().getAsInt();
        int count = 0;
        for (int d : dist) if (d == maxDist) count++;
        return count;
    }
}