import java.util.*;

class Solution {
    public int DFS(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited) {
        visited.add(start);
        int size = 1; // 현재 노드를 포함한 네트워크 그룹의 크기
        for (int neighbor : graph.get(start)) {
            if (!visited.contains(neighbor)) {
                size += DFS(graph, neighbor, visited);
            }
        }
        return size;
    }

    public int solution(int n, int[][] computers) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // 그래프 생성
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int answer = 0;
        Set<Integer> visited = new HashSet<>();

        // 모든 노드를 탐색하며 네트워크 그룹의 개수를 센다
        for (int i = 0; i < computers.length; i++) {
            if (!visited.contains(i)) {
                answer += 1;
                DFS(graph, i, visited);
            }
        }

        return answer;
    }
}