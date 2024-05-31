import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        StringBuilder sb = new StringBuilder(s);
        //1. 특수문자 제거
        s = s.replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]"," ");//특수문자를 공백으로 치환
        
        //2. 공백 을 기준으로 split
        String[] arr = s.split(" ");
        StringTokenizer st = new StringTokenizer(s," ",false);
        
        //3. HashMap에 삽입
        Map<String,Integer> hm = new HashMap<>();
        while(st.hasMoreTokens()){
            String key = st.nextToken();
            if(hm.containsKey(key)) hm.put(key,hm.get(key)+1);
            else hm.put(key,1);
        }
        
        int[] answer = new int[hm.size()];
        int cnt = hm.size();
        int idx =0;
        //4. value값이 높은순서대로 key반환
        for(int i=0; i<answer.length; i++){
            for(String key : hm.keySet()){
                int value = hm.get(key);
                if(cnt == value){
                    cnt--;
                    answer[i] = Integer.parseInt(key);
                    break;
                }
            }
        }
        return answer;
    }
}