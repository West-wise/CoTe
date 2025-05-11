import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        if(N == 1){
            System.out.println(0);
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i <N; i++){
            pq.add(Integer.parseInt(input.readLine()));
        }
        int sum = 0;
        int result = 0;
        Queue<Integer> q = new PriorityQueue<>();
        while(!pq.isEmpty()){
            int tmp = pq.poll();
            if(!pq.isEmpty())tmp += pq.poll();
            q.add(tmp + sum);
            if(pq.isEmpty()) break;
            pq.add(tmp);
        }
        while(!q.isEmpty()){
            result += q.poll();
        }

        System.out.println(result);

    }
}