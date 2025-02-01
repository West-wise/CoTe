import java.util.*;
class Solution {
    public int DFS(Map<Integer,List<Integer>> map, int start,boolean[] visited, int skip){
        visited[start] = true;
        int cnt = 1;
        for(int arr : map.get(start)){
            if(!visited[arr] && arr != skip){
                cnt += DFS(map,arr,visited,skip);
            }
        }
        return cnt;
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 모든 간선을 다 끊어보면서 min값을 비교해야할듯하다.
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int[] arr : wires){
            int start = arr[0], next = arr[1];
            // 양방향
            map.computeIfAbsent(start, k -> new ArrayList<>()).add(next);
            map.computeIfAbsent(next, k -> new ArrayList<>()).add(start);
        }
        int left = 0, right = 0;

        for(int[] arr : wires){
            int start = arr[0], next = arr[1];
            boolean[] visited = new boolean[n+1], visited2 = new boolean[n+1];
            left = DFS(map,start,visited,next);
            right = DFS(map,next,visited2,start);
            answer = Math.min(answer, Math.abs(left-right));
        }
        return answer;
    }
}