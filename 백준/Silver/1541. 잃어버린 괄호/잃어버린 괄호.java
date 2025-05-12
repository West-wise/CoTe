import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static int N,M;

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<String> arr = new ArrayList<>();
        Matcher mc = Pattern.compile("\\d+|[+\\-*/]").matcher(input.readLine());
        while (mc.find()) {
            arr.add(mc.group());
        }
        Deque<Integer> stack = new ArrayDeque<>();
        Stack<String> op = new Stack<>();
        for(String source : arr){
            try{
                int num = Integer.parseInt(source);
                if(!stack.isEmpty()){
                    if(op.peek().equals("+")){
                        op.pop();
                        num += stack.pollLast();
                    }
                }
                stack.addLast(num);
            } catch (NumberFormatException e){
                // 이 경우에는 부호잖아 (- or +)
                op.add(source);
            }
        }
        int result = stack.pop();
        while(!stack.isEmpty()){
            result -= stack.pop();
        }

        System.out.println(result);

    }
}