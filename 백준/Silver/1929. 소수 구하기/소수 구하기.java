import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N+1];
        arr[1] = true;
        int sqrt = (int) Math.sqrt(N);
        for(int i = 2; i<=sqrt; i++){
            if(!arr[i]){
                for(int k = i*i; k <= N; k+=i){
                    arr[k] = true;
                }
            }
        }
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = M; i<=N; i++){
            if(!arr[i]){
                bf.write(i + "\n");
            }
        }
        bf.flush();
        bf.close();
    }
}