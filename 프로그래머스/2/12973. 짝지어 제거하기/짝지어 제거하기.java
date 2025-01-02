import java.util.*;
import java.util.stream.Collectors;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = s.chars().mapToObj(c -> (char)c).collect(Collectors.toCollection(Stack::new));
        Stack<Character> tmp = new Stack<>();

        while(!stack.isEmpty()){
            if(tmp.isEmpty()){
                tmp.push(stack.pop());
                continue;
            }
            if(tmp.peek() == stack.peek()){
                tmp.pop();
                stack.pop();
            } else{
                tmp.push(stack.pop());
            }
        }
        return tmp.isEmpty() ? 1 : 0;
    }
}