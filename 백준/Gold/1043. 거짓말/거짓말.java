import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static int N, M;
    public static boolean[] truth;
    public static int[] parent;
    public static List<List<Integer>> parties = new ArrayList<>(); // 파티 정보 저장

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());
        int knownCount = Integer.parseInt(st.nextToken());

        truth = new boolean[N + 1];
        while (st.hasMoreTokens()) {
            int person = Integer.parseInt(st.nextToken());
            truth[person] = true;
        }

        parent = new int[N + 1];
        IntStream.rangeClosed(1, N).forEach(i -> parent[i] = i); // 초기화

        // 파티 입력 및 union 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int num = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.add(person);
            }

            // 파티 인원끼리 유니온
            for (int j = 0; j < party.size() - 1; j++) {
                union(party.get(j), party.get(j + 1));
            }

            parties.add(party); // 파티 정보 저장
        }

        // 진실을 아는 사람의 루트를 따로 저장
        Set<Integer> trueRoots = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            if (truth[i]) {
                trueRoots.add(find(i));
            }
        }

        // 각 파티의 대표자가 trueRoots에 포함되는지 확인
        int answer = 0;
        for (List<Integer> party : parties) {
            int root = find(party.get(0));
            if (!trueRoots.contains(root)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (rootA < rootB) {
                parent[rootB] = rootA;
            } else {
                parent[rootA] = rootB;
            }
        }
    }

    public static int find(int a) {
        if (parent == null || a < 1 || a >= parent.length) return a; // null-check & 범위 확인
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
