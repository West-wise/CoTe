import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        if (line == null || line.isEmpty()) return;  // null 체크

        List<String> arr = new ArrayList<>();
        Matcher mc = Pattern.compile("\\d+|[+\\-]").matcher(line);
        while (mc.find()) {
            arr.add(mc.group());
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.size(); i++) {
            String token = arr.get(i);
            if (token == null) continue;
            if (token.equals("+")) {
                // + 연산자일 경우 → 다음 수 미리 받아서 계산
                if (i + 1 < arr.size()) {
                    try {
                        int right = Integer.parseInt(arr.get(i + 1));
                        if (!stack.isEmpty()) {
                            int left = stack.pollLast();
                            stack.addLast(left + right);
                        } else {
                            stack.addLast(right); // 앞에 아무것도 없을 때
                        }
                        i++; // 이미 다음 숫자 처리했으므로 skip
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number after '+' at index " + i);
                    }
                }
            } else if (token.equals("-")) {
                // - 연산자는 그대로 두고 다음 숫자를 따로 처리
                continue;
            } else {
                try {
                    int num = Integer.parseInt(token);
                    stack.addLast(num);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid token: " + token);
                }
            }
        }

        // 모든 숫자 stack에 있음 → 맨 앞에서부터 차례로 뺄셈 수행
        int result = stack.isEmpty() ? 0 : stack.pollFirst();
        while (!stack.isEmpty()) {
            result -= stack.pollFirst();
        }

        System.out.println(result);
    }
}
