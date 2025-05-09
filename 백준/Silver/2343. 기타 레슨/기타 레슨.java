import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;

    public static int total(int n){
        return (n * (n+1))/2;
    }
    public static int binary_search(int[] array, int start, int end){

        while(start <= end){
            int mid = (start + end)/2;
            int sum = 0;
            int count = 0;
            for(int i =0; i<N; i++){
                if(sum + array[i] > mid){
                    count++;
                    sum = 0;
                }
                sum += array[i];
            }
            if(sum != 0) count++;
            if(count > M){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(binary_search(array, Arrays.stream(array).max().orElse(0), Arrays.stream(array).sum()));
    }
}