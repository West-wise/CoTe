import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static int N,M;
    public static Map<Integer, List<Integer>> map;
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        map = new HashMap<>();
        for(int i = 1; i<=N; i++){
            map.putIfAbsent(i, new ArrayList<>());
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map.get(from).add(to);
            parent[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<=N; i++) {
            if (parent[i] == 0) queue.add(i);
        }
        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()){
            int current = queue.poll();
            answer.add(current);
            for(int val : map.get(current)){
                parent[val]--;
                if(parent[val] == 0) queue.add(val);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int val : answer){
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString());
    }
}