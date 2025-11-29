import java.util.*;
class Solution {
    public int solution(int N, int number) {

        List<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0; i<=8; i++){
            dp.add(new HashSet<>());
        }
        int catnum = 0;
        for(int i = 1; i<= 8; i++){
            catnum = catnum*10 + N;
            dp.get(i).add(catnum);
        }

        for(int i = 1; i<=8; i++){
            Set<Integer> current = dp.get(i);
            for(int k = 1; k < i; k++){
                Set<Integer> setA = dp.get(k);
                Set<Integer> setB = dp.get(i-k);
                for(Integer A : setA){
                    for(Integer B : setB){
                        current.add(A+B);
                        current.add(A-B);
                        current.add(B-A);
                        current.add(A*B);
                        if(A != 0 && B != 0){
                            current.add(A/B);
                        }
                    }
                }
            }
            if(current.contains(number)) return i;
        }
        return -1;
    }
}