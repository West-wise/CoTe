import java.io.*;
import java.util.*;

public class Main {
    private static void dfs(int start, Map<Integer, List<Integer>> map, boolean[] visited){
        if(visited[start]) return;
        visited[start] = true;
        List<Integer> tmp = map.get(start);
        if(tmp == null) return;
        for(int next : map.get(start)){
            if(!visited[next]){
                dfs(next, map, visited);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(a, k-> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k-> new ArrayList<>()).add(a);
        }

        boolean[] visited = new boolean[n+1];
        int count = 0;
        for(int i = 1; i<=n; i++){
            if(!visited[i]){
               dfs(i, map, visited);
               count++;
            }
        }

        System.out.println(count);
    }
}
