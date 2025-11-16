import java.util.*;
class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] p : path){
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }

        int[] before = new int[n];
        Arrays.fill(before, -1);
        for(int[] o : order){
            if(o[1] == 0) return false;
            before[o[1]] = o[0];
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        queue.add(0);
        int visitedCount = 1;

        while(!queue.isEmpty()){
            int node = queue.poll();
            if(map.containsKey(node)){
                for(int nxt : map.get(node)){
                    if(!visited[nxt]){
                        visited[nxt] = true;
                        queue.add(nxt);
                        visitedCount++;
                    }
                }
                map.remove(node);
            }
            for(int nxt : graph.get(node)){
                if(visited[nxt]) continue;

                int required = before[nxt];
                if(required != -1 && !visited[required]){
                    map.computeIfAbsent(required, k -> new ArrayList<>()).add(nxt);
                    continue;
                }
                // 정상적으로 방문 가능
                visited[nxt] = true;
                queue.add(nxt);
                visitedCount++;
            }
        }
        return (visitedCount == n);
    }
}