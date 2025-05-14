import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int N, M;

    public static boolean isPrime(int number){
        int sqrt = (int)Math.sqrt(number);
        for(int i = 2; i<=sqrt; i++){
            if(number%i==0) return false;
        }
        return true;
    }

    public static boolean isPalindrom(int number){
        int number_len = (int) Math.log10(number) + 1;
        for(int i = 0; i<number_len/2; i++){
            int head = (number / (int) Math.pow(10,number_len - i -1)) % 10;
            int tail = (number / (int) Math.pow(10,i)) % 10;
            if(head != tail){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());

        int sqrtM = (int)Math.sqrt(M);
        // N보다 크거나 같은 수 중에서의 소수
        int result = 0;
        for(int i = N; ; i++){
            if(isPalindrom(i)){
                if(i != 1 && isPrime(i)){
                    result = i;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}