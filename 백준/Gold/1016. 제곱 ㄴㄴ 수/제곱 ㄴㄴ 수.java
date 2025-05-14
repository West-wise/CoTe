import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static long N, M;
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        long sqrtM = (long) Math.sqrt(M);
        int count = 0;
        // N과 M은 최대 100만의 차이가 난다.
        // 이정도는 int값에서 커버칠수있는 범위
        boolean[] field = new boolean[(int) (M-N+1)];
        for(int i = 2; i<=sqrtM; i++){
            long power = (long) i * i;
            long start = (N % power == 0 ? N / power : N / power + 1);
            for(long k = start; k<=M/power; k++){
                field[(int) ((k*power) - N)] = true;
            }
        }
        for (boolean b : field) {
            if (!b) count++;
        }
        System.out.println(count);
    }
}