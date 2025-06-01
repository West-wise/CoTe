import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static int[] indegree, time, result;
    public static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];
        time = new int[N+1];
        result = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            graph[i] =  new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(input.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int pre_build = Integer.parseInt(st.nextToken()); // pre_build가 여러개일 수 있다.
                if(pre_build == -1)break;
                graph[pre_build].add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=N; i++){
            result[i] = time[i];
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int current = q.poll();
            for(Integer next : graph[current]){
                if (next == null) continue;
                indegree[next]--;
                result[next] = Math.max(result[next] , result[current] + time[next]);
                if(indegree[next]==0) q.offer(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}