import java.io.*;
import java.sql.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static int N,M;
    public static List<Integer>[] graph ;
    public static int[] indegree, time, result;
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        indegree = new int[N+1];
        time = new int[N+1];
        result = new int[N+1];

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(input.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int pre_build = Integer.parseInt(st.nextToken());
                if(pre_build==-1) break;
                graph[pre_build].add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<=N; i++){
            result[i] = time[i];
            if(indegree[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph[current]){
                indegree[next]--;
                result[next] = Math.max(result[next], result[current] + time[next]);
                if(indegree[next] == 0 )queue.offer(next);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N; i++){
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }
}