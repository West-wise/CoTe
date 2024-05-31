import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0,sum=0 ,cnt =0;
        Map<String,Integer> hm = new HashMap<>() , solution = new HashMap<>();
        List<String> al = new ArrayList<>(); 
       
        for(int i=0; i<want.length; i++){
            solution.put(want[i],number[i]);
        }
        
        for(int k=0; k<=discount.length-10; k++){
            al.clear();
            hm.clear();
            for(String s : want){ hm.put(s,0); }
            for(int i=k; i<k+10; i++){ al.add(discount[i]);}//10개만 넣기
            for(String str : al){
                if(hm.containsKey(str)){ hm.put(str,hm.get(str)+1); }
                else break;
            }
            if(solution.equals(hm)){
                cnt++;
            }
        }
        return cnt;
    }
}