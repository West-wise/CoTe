import java.io.*;
import java.util.*;

public class Main {

    private static void dfs(int start, List<Integer>[] graph, BitSet visited) {
        if (visited == null || graph == null) return;
        if (visited.get(start)) return;

        visited.set(start); // 방문 처리
        List<Integer> neighbors = graph[start];
        if (neighbors == null) return; // null-safe

        for (int next : neighbors) {
            if (!visited.get(next)) {
                dfs(next, graph, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수

        // comment: 인접 리스트 배열 생성
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // comment: 간선 입력 처리
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a); // 무방향 그래프
        }

        BitSet visited = new BitSet(n + 1); // comment: boolean[]보다 메모리 효율 좋음
        int count = 0;

        // comment: 연결 요소 개수 세기
        for (int i = 1; i <= n; i++) {
            if (!visited.get(i)) {
                dfs(i, graph, visited);
                count++;
            }
        }

        System.out.println(count);
    }
}
