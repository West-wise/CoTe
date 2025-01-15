import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String,Integer> answer = new HashMap<>();


        Map<String,String> referralMap = new HashMap<>();
        for(int i=0; i<enroll.length; i++){ referralMap.put(enroll[i],referral[i]);}

        for(int i=0; i<seller.length; i++){
            String name = seller[i];
            int earn = amount[i] * 100;
            Map<String,Integer> tmp = new HashMap<>();
            tmp.put(seller[i], amount[i]*100);
            while(name != null && !name.equals("-")) {
                int commission = earn / 10; //10% 커미션
                int profit = earn - commission; // 최종 수익금

                answer.put(name, answer.getOrDefault(name, 0) + profit);
                //다음으로 이동
                name = referralMap.get(name);
                earn = commission;
                if(earn<1) break;

            }
        }
        int[] ans2 = new int[enroll.length];
        for(int i=0; i<enroll.length; i++) {
            ans2[i] = answer.getOrDefault(enroll[i],0);
        }
        return ans2;
    }
}