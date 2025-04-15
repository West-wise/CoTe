import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        Queue<Integer> goal = new LinkedList<>();
        Stack<Integer> answer = new Stack<>();
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            goal.add(Integer.parseInt(input.readLine()));
        }

        for (int i = 1; i <= n; i++) {
            result.add("+");
            answer.push(i);

            // ⚠️ null 체크 추가!
            while (!answer.isEmpty() && goal.peek() != null && answer.peek().equals(goal.peek())) {
                answer.pop();
                goal.poll();
                result.add("-");
            }
        }

        if (!goal.isEmpty()) {  // ✅ 목표 큐가 비어있지 않으면 실패
            System.out.println("NO");
        } else {
            for (String s : result) {
                System.out.println(s);
            }
        }
    }
}
