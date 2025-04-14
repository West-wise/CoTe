import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int window = Integer.parseInt(st.nextToken());
        List<Integer> answer = new ArrayList<>();
        st = new StringTokenizer(input.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i<n; i++){
            if(!deque.isEmpty() && deque.peekFirst() <= i-window){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && arr[deque.peekLast()] > arr[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            answer.add(arr[deque.peekFirst()]);
        }

        StringBuilder sb = new StringBuilder();
        for (int val : answer) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString());


    }
}