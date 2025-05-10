import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;

    public static int binary_search(){
        int start = 1;
        int end = M;
        int result = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            int sum = 0;
            for(int i = 1; i<=N; i++){
                sum += Math.min(mid/i, N);
            }
            if(sum < M){
                start = mid + 1;
            } else{
                end = mid -1;
                result = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());
        System.out.println(binary_search());

    }
}