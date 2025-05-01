import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static boolean isPrime(int n){
        if(n <= 1) return false;
        if(n<= 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    private static void dfs(int num, int depth) throws IOException {
        if(!isPrime(num)) return;
        if(depth == N){
            bw.write(num+"\n");
            return;
        }
        for(int i = 1; i<=9; i+=2){
            dfs(num*10+i, depth+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int prime : new int[]{2, 3, 5, 7}) {
            dfs(prime, 1); // 첫 자리는 홀수 소수만
        }
        bw.flush();

    }
}
