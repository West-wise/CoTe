import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder dfsList = new StringBuilder();
    public static StringBuilder bfsList = new StringBuilder();
    public static void dfs(int node, Map<Integer,List<Integer>> map, boolean[] visited){
        visited[node] = true;
        dfsList.append(node).append(" ");
        List<Integer> list = map.get(node);
        if(list != null){
            for(int i : list){
                if(!visited[i]) dfs(i, map, visited);
            }
        }
    }

    public static void bfs(int node, Map<Integer, List<Integer>> map, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);

        while(!queue.isEmpty()){
            int current = queue.poll();
            bfsList.append(current).append(" ");
            List<Integer> list = map.get(current);
            if(list != null){
                for(int neighbor : list){
                    if(!visited[neighbor]){
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        for(int node : map.keySet()){
            Collections.sort(map.get(node));
        }

        boolean[] visited = new boolean[n+1];
        dfs(v, map, visited);
        visited = new boolean[n+1];
        bfs(v, map, visited);

        System.out.println(dfsList.toString());
        System.out.println(bfsList.toString());

    }
}