import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] dfs(int start, Map<Integer, List<int[]>> map, boolean[] visited){
        int dist_sum = 0;
        int last_node = start;
        visited[start] = true;
        List<int[]> neighbors = map.get(start);
        if(neighbors != null){
            for(int[] neighbor : neighbors){
                if(!visited[neighbor[0]]){
                    int[] next = dfs(neighbor[0], map, visited);
                    int tmp_cost = next[1] + neighbor[1];
                    if(tmp_cost > dist_sum){
                        dist_sum = tmp_cost;
                        last_node = next[0];
                    }
                }
            }
        }
        return new int[]{last_node, dist_sum};
    }
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0; i<N; i++){
            String[] data = input.readLine().split(" ");
            int start = Integer.parseInt(data[0]);
            for(int k = 1; k < data.length-1; k+=2){
                int end = Integer.parseInt(data[k]);
                int cost = Integer.parseInt(data[k+1]);
                map.computeIfAbsent(start, arr -> new ArrayList<>()).add(new int[]{end, cost});
            }
        }
        int[] first = dfs(1, map, new boolean[N+1]);
        System.out.println(dfs(first[0], map, new boolean[N + 1])[1]);
    }
}