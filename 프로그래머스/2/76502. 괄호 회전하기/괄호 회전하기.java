import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        ArrayList<Character> al = new ArrayList<>();
        for(char c : arr){
            al.add(c);
        }
        
        for(int i=0; i<s.length(); i++){
            if(check(al))answer++;;
            al.add(al.get(0));//첫 요소를 받아와 맨 뒤에 추가
            al.remove(0); //첫 요소 삭제;
        }
        return answer;
    }
    
    private static boolean check(ArrayList al){
        if(al.get(0).equals(')') || al.get(0).equals(']') || al.get(0).equals('}')) return false; //첫 시작이 닫는 괄호이면 틀림
        
        boolean answer = true;
        Stack<Character>st = new Stack<>();
        for(int i = 0; i <al.size(); i++){
            char c = (Character)al.get(i);
            if(c == '(' || c== '[' || c =='{') st.push(c);
            else{
                if(st.isEmpty()) return false;
                switch(c){
                case ')':
                    if(st.peek().equals('(')) st.pop();
                    break;
                case ']': 
                    if(st.peek().equals('[')) st.pop();
                    break;
                case '}':
                    if(st.peek().equals('{')) st.pop();
                    break;
                        
            }
            }
        }
        
        if(st.size()!=0) answer =  false;
        
        return answer;

    }
}