import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static boolean binary_search(int[] array, int target, int start, int end){
        if(start > end) return false;
        int mid = start+(end-start)/2;

        if(array[mid] == target) return true;
        else if(array[mid] < target) return binary_search(array, target, mid + 1, end);
        else return binary_search(array, target, start, mid - 1);
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

        for(int i : array2){
            System.out.println(binary_search(array1, i , 0, N-1) ? 1 : 0);
        }
    }
}