import java.util.*;

class Solution {
    static int[] parent, size;

    // Find 연산 (경로 압축 적용)
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    // Union 연산 (랭크 기반 최적화 적용)
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA; // rootB를 rootA에 병합
            size[rootA] += size[rootB]; // 서브트리 크기 갱신
        }
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            // 1. 부모 및 크기 배열 초기화
            parent = new int[n + 1];
            size = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                parent[j] = j; // 자기 자신을 부모로 초기화
                size[j] = 1; // 각 노드 크기 1로 초기화
            }

            // 2. 간선 하나 제외하고 Union-Find로 연결
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; // 하나의 간선을 제외하고 진행
                union(wires[j][0], wires[j][1]);
            }

            // 3. 두 개의 분리된 트리 크기 계산
            int root = find(1); // 1번 노드를 포함하는 그룹 크기
            int groupSize1 = size[root];
            int groupSize2 = n - groupSize1; // 전체 노드 개수에서 빼기

            answer = Math.min(answer, Math.abs(groupSize1 - groupSize2)); // 최솟값 갱신
        }

        return answer;
    }
}
