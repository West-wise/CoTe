import java.io.*;
import java.util.*;
public class Main {
    public static int N,M;
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());
        parent = new int[N+1];
        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(input.readLine());
            for(int k = 1; k<=N; k++){
                int next = Integer.parseInt(st.nextToken());
                if(next == 1) union(i,k);
            }
        }

        st = new StringTokenizer(input.readLine());
        int first = find(Integer.parseInt(st.nextToken()));
        while(st.hasMoreTokens()){
            if(first != find(Integer.parseInt(st.nextToken()))){
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b){
        int rootA = find(a), rootB = find(b);
        if(rootA != rootB){
            if(rootA < rootB){
                parent[rootB] = rootA;
            } else{
                parent[rootA] = rootB;
            }
        }
    }
    public static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}