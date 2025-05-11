import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        PriorityQueue<Integer> overZero = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> underZero = new PriorityQueue<>();
        int oneCnt = 0;
        if(N == 1){
            System.out.println(Integer.parseInt(input.readLine()));
            return;
        }

        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(input.readLine());
            if(a > 1) overZero.add(a);
            else if(a == 1) oneCnt++;
            else underZero.add(a);
        }
        int result = 0;

        while(!overZero.isEmpty()) {
            if(overZero.size() < 2) {
                result += overZero.poll();
                break;
            }
            result += (overZero.poll() * overZero.poll());
        }

        while(!underZero.isEmpty()){
            if(underZero.size() < 2){
                result += underZero.poll();
                break;
            }
            result += (underZero.poll() * underZero.poll());
        }

        System.out.println(result + oneCnt);
    }
}