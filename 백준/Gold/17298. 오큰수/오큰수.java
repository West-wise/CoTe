import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        for(int i = 0; i<N; i++){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()] ){
                int idx = stack.pop();
                answer[idx] = nums[i];
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int number : answer){
            sb.append(number).append(" ");
        }
        System.out.println(sb.toString());
    }
}