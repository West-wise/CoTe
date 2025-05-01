import java.io.*;

public class Main {

    // 비트맵 방식으로 소수 판별하기
    private static void sieve(byte[] sieve, int max) {
        for (int i = 2; i * i <= max; i++) {
            if ((sieve[i >> 3] & (1 << (i & 7))) == 0) {  // i가 소수인 경우
                for (int j = i * i; j <= max; j += i) {
                    sieve[j >> 3] |= 1 << (j & 7);  // 소수가 아니라고 표시
                }
            }
        }
    }

    // 숫자의 자릿수별 소수 판별
    private static boolean check(int number, byte[] sieve) {
        int divisor = 1;
        while (divisor <= number) {
            int prefix = number / divisor;
            // 비트맵을 이용하여 자릿수 별로 소수 판별
            if ((sieve[prefix >> 3] & (1 << (prefix & 7))) != 0) return false;
            divisor *= 10;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 자릿수 크기
        int start = 2 * (int) Math.pow(10, n - 1);  // 시작 값
        int end = 8 * (int) Math.pow(10, n - 1);  // 끝 값

        // 최대 값 구하기 (범위 내에서)
        int max = 8 * (int) Math.pow(10, n - 1);

        // 비트맵 방식으로 소수 판별
        byte[] sieve = new byte[(max >> 3) + 1];  // 비트맵 크기 설정
        sieve[0] = 0b00000010;  // 0과 1은 소수가 아님

        // 에라토스테네스의 체를 통해 소수 구하기
        sieve(sieve, max);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 숫자 탐색
        for (int i = start; i < end; i++) {
            if ((sieve[i >> 3] & (1 << (i & 7))) == 0 && check(i, sieve)) {
                bw.write(i + "\n");  // 유효한 수 출력
            }
        }

        bw.flush();  // 출력 버퍼 비우기
    }
}
