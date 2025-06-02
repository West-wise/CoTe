import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static List<int[]>[] graph;
    public static List<Integer>[] trace;
    public static int[] indegree, result;

    public static int BFS(int target) {
        boolean[] visited = new boolean[N+1];
        visited[target] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int node : trace[current]) {
                for(int[] edge : graph[node]){
                    int next = edge[0];
                    int cost = edge[1];
                    if(next == current && result[current] == result[node] + cost){
                        cnt++;
                        if(!visited[node]){
                            queue.offer(node);
                            visited[node] = true;
                        }
                        break;
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());
        graph = new ArrayList[N + 1];
        trace = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            trace[i] = new ArrayList<>();
        }
        indegree = new int[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            indegree[end]++;
            graph[start].add(new int[]{end, time});
        }
        st = new StringTokenizer(input.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int targetNode = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int[] next : graph[current]) {
                int nextNode = next[0];
                int spendTime = next[1];
                indegree[nextNode]--;
                if (indegree[nextNode] == 0) queue.offer(nextNode);
                if (result[nextNode] < result[current] + spendTime) {
                    result[nextNode] = result[current] + spendTime;
                    trace[nextNode].clear();
                    trace[nextNode].add(current);
                } else {
                    trace[nextNode].add(current);
                }
            }
        }
        System.out.println(result[targetNode]);
        System.out.println(BFS(targetNode));
    }
}