import java.util.*;
class Solution {
    public int DFS(int[][] graph, Set<Integer> visited, List<Integer> answer ,int[] info, int sheep, int wolf) {
        if (sheep > wolf) {
            answer.add(sheep);
        } else{
            return 0;
        }

        for(int[] node : graph){
            int parent = node[0], child = node[1];
            if (visited.contains(parent) && !visited.contains(child)){
                visited.add(child);
                if(info[child] == 0 ){
                    DFS(graph, visited, answer, info, sheep +1 , wolf);
                } else{
                    DFS(graph, visited, answer, info, sheep, wolf+1);
                }
                visited.remove(child);
            }
        }

        return answer.stream().max(Integer::compareTo).orElse(0);
    }
    public int solution(int[] info, int[][] edges) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        return DFS(edges,visited,answer,info, 1, 0);
    }
}