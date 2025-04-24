import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);
                    if(absA == absB) {
                        return Integer.compare(a, b);
                    }
                    return Integer.compare(absA, absB);
                }
        );
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(input.readLine());
            if(num != 0){
                pq.add(num);
            } else {
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else{
                    System.out.println(pq.poll());
                }
            }
        }
    }
}