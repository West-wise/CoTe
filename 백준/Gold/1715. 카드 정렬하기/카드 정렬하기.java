import java.io.*;
import java.util.*;

public class Main {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());

        if (N <= 0) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String line = input.readLine();
            if (line == null || line.trim().isEmpty()) continue; // null 체크 및 빈 줄 방지
            pq.add(Integer.parseInt(line));
        }

        if (pq.size() == 1) {
            System.out.println(0);
            return;
        }

        int result = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int merged = first + second;
            result += merged;

            pq.add(merged);
        }

        System.out.println(result);
    }
}
