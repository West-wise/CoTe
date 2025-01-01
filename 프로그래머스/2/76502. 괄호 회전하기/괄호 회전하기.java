import java.util.*;


class Solution {
    boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            switch(c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
    public int solution(String s) {
        int answer = 0;
        String tmp = s;
        for(int i=0; i<s.length(); i++) {
            if(check(tmp))answer++;
            tmp = tmp.substring(1) + tmp.charAt(0);;
        }
        return answer;
    }
}