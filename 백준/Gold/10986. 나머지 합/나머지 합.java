import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        long answer =0;
        long[] S = new long[n];
        int[] C = new int[m];
        S[0] = array[0];
        for(int i = 1; i < n; i++){
            S[i] = S[i-1] + array[i];
        }
        for(int i = 0; i<n; i++){
            int remain = (int) (S[i] % m);
            if(remain == 0){
                answer++;
            }
            C[remain]++;
        }

        for(int i = 0; i<m; i++){
            if(C[i]>1){
                answer += ((long) C[i] * (C[i]-1) / 2);
            }
        }
        System.out.println(answer);
    }
}