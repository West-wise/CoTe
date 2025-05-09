import java.io.*;
import java.util.*;

public class Main {
    static int N;

    // 간선 클래스 정의
    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    // DFS 결과 저장용 클래스
    static class Result {
        int node, dist;
        Result(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static Result dfs(int start, List<Edge>[] map, boolean[] visited) {
        if (visited == null || map == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }

        visited[start] = true;
        int maxDist = 0;
        int farthestNode = start;

        if (map[start] != null) {
            for (Edge edge : map[start]) {
                if (edge != null && !visited[edge.to]) {
                    Result res = dfs(edge.to, map, visited);
                    int totalDist = res.dist + edge.cost;
                    if (totalDist > maxDist) {
                        maxDist = totalDist;
                        farthestNode = res.node;
                    }
                }
            }
        }

        return new Result(farthestNode, maxDist);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());

        // 배열로 바꿔 성능 향상
        List<Edge>[] map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break; // 문제 정의에 따라 종료
                int cost = Integer.parseInt(st.nextToken());
                map[start].add(new Edge(end, cost));
            }
        }

        Result first = dfs(1, map, new boolean[N + 1]);
        Result second = dfs(first.node, map, new boolean[N + 1]);
        System.out.println(second.dist);
    }
}
