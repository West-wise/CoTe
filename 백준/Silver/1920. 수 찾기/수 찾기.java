import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static boolean binary_search(int[] array, int target){
        int start = 0;
        int end = array.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(array[mid] == target) return true;
            else if(array[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] array1 = new int[N];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < N; i++){
            array1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array1);
        st = new StringTokenizer(input.readLine());
        M = Integer.parseInt(st.nextToken());
        int[] array2 = new int[M];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < M; i++){
            array2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i : array2) {
            sb.append(binary_search(array1, i) ? "1\n" : "0\n");
        }
        System.out.print(sb);
    }
}