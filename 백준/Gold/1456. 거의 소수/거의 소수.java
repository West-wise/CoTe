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
        long m = (long) Math.sqrt(M);
        // false는 소수, true는 합성수
        boolean[] prime_number = new boolean[(int) m+1];
        prime_number[0] = prime_number[1] = true;
        for(long i = 2; i<=m; i++){
            if(!prime_number[(int)i]){
                for(long k = i * i; k<=m; k+=i){
                    prime_number[(int)k] = true;
                }
            }
        }

        int count = 0;
        // m이상은 소수가 아니다...
        for(int i = 2; i <= m; i++){
            if(!prime_number[i]){
                // i^2부터 시작
                long power = (long) i * i;
                while(power <= M){
                    if(power >= N) count++;
                    if(power > M/i) break;
                    power *= i;
                }
            }
        }
        System.out.println(count);
    }
}