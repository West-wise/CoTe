import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int cnt =0;
        ArrayList<String> al = new ArrayList<>();
        
        
        for(int i=0; i<words.length;i++){
            for(int k=0; k<n; k++){
                if(check(al,words[cnt])){ //중복 or 끝말잇기 성립 검사
                    answer[0] = k+1;
                    answer[1] = i+1;
                    return answer;
                }
                else{
                    al.add(words[cnt]); //arraylist에 추가
                    if(cnt == words.length-1) return answer;
                    else cnt++;
                }
            }
        }
        

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("정상적");

        return answer;
    }
    
    public static boolean check(ArrayList al , String word){
        if(!al.isEmpty()){
            String lastWord = (String)al.get(al.size()-1);
            if(al.contains(word)){
                return true; 
            }
            if(lastWord.charAt(lastWord.length()-1) != word.charAt(0)) return true;
        }

        return false; //비어있거나 아님말고

    }
}