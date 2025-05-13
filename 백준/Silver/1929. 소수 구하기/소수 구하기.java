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
        int[] arr = new int[N+1];
        for(int i = M; i<=N; i++){
            arr[i] = 1;
        }
        arr[1] = 0;
        for(int i = 2; i<=Math.sqrt(N); i++){
            for(int k = 2; k <= N/i; k++){
                arr[i*k] = 0;
            }
        }
        for(int i = M; i<=N; i++){
            if(arr[i] != 0){
                System.out.println(i);
            }
        }
    }


}