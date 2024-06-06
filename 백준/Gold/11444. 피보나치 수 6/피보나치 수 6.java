import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static long MOD = 1000000007;

    public static long fibo(long num, Map<Long, Long> memo) {
        if (memo.containsKey(num)) {
            return memo.get(num);
        }
        if (num <= 1) {
            return num;
        } else if (num == 2) {
            return 1;
        }

        long result;
        if (num % 2 == 0) { // 짝수
            result = (fibo(num / 2, memo) * (fibo(num / 2 + 1, memo) + fibo(num / 2 - 1, memo))) % MOD;
        } else { // 홀수
            result = (fibo((num + 1) / 2, memo) * fibo((num + 1) / 2, memo) + fibo((num - 1) / 2, memo) * fibo((num - 1) / 2, memo)) % MOD;
        }

        memo.put(num, result);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        Map<Long, Long> memo = new HashMap<>();
        System.out.println(fibo(number, memo));
        sc.close();
    }
}
