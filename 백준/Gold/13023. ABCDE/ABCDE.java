import java.io.*;
import java.util.*;

public class Main { ;
    private static Map<Integer, List<Integer>> friends;
    private static int n,m;
    private static boolean dfs(int node, Set<Integer> visited, int depth) {
        if(depth == 5) return true;
        visited.add(node);
        if(friends.get(node) != null){
            for(int val : friends.get(node)){
                if(!visited.contains(val)){
                    if(dfs(val, visited, depth+1)) return true;
                }
            }
        }
        visited.remove(node);
        return false;
    }
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        friends = new HashMap<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            friends.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        for(int  i=0; i<n; i++){
            if(dfs(i, new HashSet<>(), 1)){
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}