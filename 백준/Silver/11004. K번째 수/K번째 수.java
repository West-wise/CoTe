import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 숫자들을 저장할 ArrayList 생성
        List<Integer> list = new ArrayList<>(N);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // Collections.sort()로 정렬
        Collections.sort(list);

        // K번째 수 출력 (인덱스는 0부터 시작하므로 K-1)
        System.out.println(list.get(K - 1));
    }
}
