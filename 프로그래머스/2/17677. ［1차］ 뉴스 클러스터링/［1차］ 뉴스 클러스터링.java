import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();    
        Map<String,Integer> arr1 =new HashMap<>(), arr2 = new HashMap<>(); 
        HashSet<String> set = new HashSet<>(); //합집합용
        
        for(int i=0; i<str1.length()-1; i++){
            String temp = str1.substring(i, i+2);
            if(Character.isAlphabetic(temp.charAt(0)) && 
               Character.isAlphabetic(temp.charAt(1))){
                arr1.put(temp,arr1.getOrDefault(temp,0)+1);
                set.add(temp);
            }  
        }
        
        for(int i=0; i<str2.length()-1; i++){
            String temp = str2.substring(i, i+2);
            if(Character.isAlphabetic(temp.charAt(0)) &&
               Character.isAlphabetic(temp.charAt(1))){
                arr2.put(temp,arr2.getOrDefault(temp,0)+1);
                set.add(temp);
            }   
        }
        int interSize = 0;
        for(String s : set){ //합집합
            interSize +=Math.max(arr1.getOrDefault(s,0),arr2.getOrDefault(s,0));
        }
        
        //공집합 및 다중집합
        for(String s : arr2.keySet()){
            if(arr1.containsKey(s)){
                answer += Math.min(arr1.get(s),arr2.get(s));
            }
        }
        
        if(interSize == 0) return 65536;
        answer = answer*65536/interSize;
        
        return answer;
    }   

}