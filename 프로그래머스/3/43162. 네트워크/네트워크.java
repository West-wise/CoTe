import java.util.*;

class Solution {

    public void DFS(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited){
        visited.add(start);
        for(int neighbor : graph.get(start)){
            if(!visited.contains(neighbor)){
              DFS(graph, neighbor, visited);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 1.일단 그래프를 만들어
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0; i<computers.length; i++){
            for(int k=0; k<computers[i].length; k++){
                if(computers[i][k] == 1 ) graph.computeIfAbsent(i,j->new ArrayList<>()).add(k);
            }
        }

        // DFS를 통해 탐색하다 보면 연결된 컴퓨터가 나온다.
        // 이미 탐색한 것을 막기위해 set 생성
        Set<Integer> visited = new HashSet<>();
        for(int key : graph.keySet()){
            if(!visited.contains(key)){
                DFS(graph, key, visited);
                answer++;
            }
        }
        return answer;
    }
}