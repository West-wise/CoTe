import java.util.*;
class Solution {
    boolean solution(String s) {
        //처음부터 이상하게 열림
        if(s.charAt(0) == ')') return false;
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            switch(c){
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if(!stack.isEmpty()){
                        stack.pop();//근데 이러면 ())도 통과되어버림
                    } else{
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}