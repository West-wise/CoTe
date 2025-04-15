import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        Queue<Integer> goal = new LinkedList<>();
        Stack<Integer> answer = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            goal.add(Integer.parseInt(input.readLine()));
        }

        for(int i = 1; i<=n; i++){
            sb.append("+\n");
            answer.push(i);
            while(!answer.isEmpty() && Objects.equals(answer.peek(), goal.peek())){
                answer.pop();
                goal.poll();
                sb.append("-\n");
            }
        }

        if(!goal.isEmpty()){
            System.out.println("NO");
        } else{
            System.out.println(sb.toString());
        }
    }
}