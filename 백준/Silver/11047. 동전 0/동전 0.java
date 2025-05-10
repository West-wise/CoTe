import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int  i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input.readLine());
        }

        int result = 0;
        for(int i = N-1; i >= 0; i--){
            if(arr[i] <= M){
                result += M/arr[i];
                M %= arr[i];
            }
            if(M == 0) break;
        }
        System.out.println(result);
    }
}