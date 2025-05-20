import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] count;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // List 배열 생성
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 역방향 간선 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to); // 역방향 저장
        }

        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            bfs(i, visited);
        }

        int max = Arrays.stream(count).max().orElse(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (count[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    // BFS 함수 (보안상 null 체크 필요 없음)
    static void bfs(int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adj[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count[next]++;
                    q.add(next);
                }
            }
        }
    }
}
