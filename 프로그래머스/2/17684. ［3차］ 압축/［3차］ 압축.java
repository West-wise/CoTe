import java.util.*;


class Solution {
    public int[] solution(String msg) {
        //int[] answer = {};

        List<String> dic = new ArrayList<>();
        for(char i = 'A'; i<='Z'; i++){
            dic.add(String.valueOf(i));
        }
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<msg.length(); i++){
            StringBuilder w = new StringBuilder(String.valueOf(msg.charAt(i)));
            
            // w 에 들어온 문자가 마지막 문자인경우 종료 
            if(i==msg.length()-1){
                answer.add(dic.indexOf(String.valueOf(msg.charAt(i)))+1);
                break;
            }
            String c = String.valueOf(msg.charAt(i+1));
            
            while(dic.contains(w+c)){
                w.append(c); 
                i++;
                
                if(i==msg.length()-1){
                    break;
                }
                c = String.valueOf(msg.charAt(i+1)); 
            }
            
            if(!dic.contains(w+c)){ //사전에 W+C가 없을 경우 추가
                dic.add(w+c); //KAO를 다시 사전에 추가
                answer.add(dic.indexOf(String.valueOf(w))+1); //KA인덱스를 answer에 추가
            }
            else{
                answer.add(dic.indexOf(String.valueOf(w))+1);
            }
            
        }
        
        
        
        return answer.stream()
                .filter(i -> i != null)
                .mapToInt(i -> i)
                .toArray();
    }
    
}