import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int win = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(!deque.isEmpty() && deque.peekFirst() <= i - win){
                deque.pollFirst();
            } // 윈도우 사이즈 제한

            while(!deque.isEmpty() && arr[deque.peekLast()] > arr[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            answer.add(arr[deque.peekFirst()]);
        }

        StringBuilder sb = new StringBuilder();
        for(int val : answer){
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString());

    }
}
