import java.io.*;
import java.util.*;
public class Main {
    public static int N,M;
    public static int[] unionArray;
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        unionArray = new int[N+1];
        for(int i =0; i<=N; i++){
            unionArray[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(input.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(flag == 0) union(a,b);
            else if(flag == 1) sb.append(isSame(a,b) ? "YES\n" : "NO\n");
        }
        System.out.println(sb.toString());
    }
    public static void union(int a, int b){
        // a가 포함되어있는 집합과 b가 포함되어있는 집합을 합친다는 의미
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            if(rootA < rootB){
                unionArray[rootB] = rootA;
            } else {
                unionArray[rootA] = rootB;
            }
        }
    }
    public static int find(int a){
        if(unionArray[a] == a) return a;
        return unionArray[a] = find(unionArray[a]);
    }

    public static boolean isSame(int a, int b){
        return find(a) == find(b);
    }
}