import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int gcd(int a, int b){
        while(b!=0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
        // N과 서로소인 수를 찾아라..

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(a * b / gcd(a,b));
        }
    }
}