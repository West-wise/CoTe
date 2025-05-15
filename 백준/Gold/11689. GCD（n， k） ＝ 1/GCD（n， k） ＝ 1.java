import java.io.*;
import java.util.*;

public class Main {
    public static long N, M;
    public static long gcd(){
        long result = N;
        for(long i = 2; i * i <=N; i++){
            if((N % i) == 0){
                while(N % i == 0){
                    N /= i;
                }
                result -= result/i;
            }
        }
        if(N > 1) result -= result/N;
        return result;
    }
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Long.parseLong(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
        // N과 서로소인 수를 찾아라..
        int count = 0;
        if(N == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(gcd());
    }
}