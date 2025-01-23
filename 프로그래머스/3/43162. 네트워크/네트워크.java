import java.util.*;
class Solution {
    public int DFS(Map<Integer,List<Integer>> graph,int start, Set<Integer> visited){

        visited.add(start);
        for(int neighbor : graph.get(start)){
            if(!visited.contains(neighbor)){
                DFS(graph,neighbor,visited);
            }
        }


        return 1;
    }
    public int solution(int n, int[][] computers) {
        // computes[n]의 n번째 요소는 자기자신을 나타낸다.
        // 컴퓨터의 번호는 0~n-1까지이다.
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<computers.length; i++) {
            for(int j=0; j<computers[i].length; j++) {
                if(computers[i][j] == 1 && i!=j) {
                    map.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        int answer = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<computers.length; i++) {
            if(!visited.contains(i) && map.containsKey(i)) {
                answer += DFS(map,i,visited);
            } else if (!map.containsKey(i)) {
                answer += 1;
            }
        }
        return answer;
    }
}