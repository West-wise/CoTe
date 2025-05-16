import java.io.*;
import java.util.*;
public class Main {
    public static long N, M;
    public static long gcd(long a, long b){
        while(b!=0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public static long makeOneNum(long digit){
        long tmp = 0;
        long unit = 1;
        for(int i = 0; i < digit; i++){
            tmp+= unit;
            unit *= 10;
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        long digit = gcd(N,M);
        StringBuilder sb = new StringBuilder();
        for(long i = 0; i<digit; i++){
            sb.append(1);
        }
        System.out.println(sb.toString());

    }
}