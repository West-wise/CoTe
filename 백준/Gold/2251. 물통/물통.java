import java.io.*;
import java.util.*;
public class Main {
    public static int A, B, C;
    public static boolean[][] visited;
    public static boolean[] result;
    public static void BFS(int A, int B){
        visited[A][B] = true;
        result[C-A-B] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{A,B});
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int a = tmp[0], b = tmp[1], c = C-a-b;
            // 문제의 조건 : a가 비어있을대 C의 값을 구할 것.
            if(a==0) result[c] = true;
            pourCase(queue, a, b, c);
        }
    }
    // a는 A에 차있는 용량, b는 B에 차있는 용량, c는 C에 차있는 용량
    public static void pourCase(Queue<int[]> queue, int a, int b, int c){
        move(queue, a+b > B ? a-(B-b) : 0, Math.min(a + b, B)); // A->B, B-b는 B에 담을 수 있는 최대 용량을 의미
        move(queue, a+c > C ? a-(C-c) : 0, b);                  // A->C, C-c는 C에 담을 수 있는 최대 용량을 의미한다.
        move(queue, a, b+c > C ? b-(C-c):0);                    // B->C
        move(queue, Math.min(a + b, A), a+b > A ? b-(A-a) : 0); // B->A
        move(queue, Math.min(a + c, A), b);                 // C->A
        move(queue, a, Math.min(b+c,B));                        // C->B
    }
    public static void move(Queue<int[]> queue, int newA, int newB){
        if(newA >=0 && newB >= 0 && !visited[newA][newB]){
            visited[newA][newB] = true;
            queue.add(new int[]{newA,newB});
        }
    }
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[C +1][C +1];
        result = new boolean[C +1];
        // 아 물을 일정 부분만 채울 수 있는게 아니라 꽉 채우거나 채우지 않거나 둘중 하나네
        BFS(0,0);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<result.length; i++){
            if(result[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}