import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int num = 0;
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0; i<=8; i++){
            dp.add(new HashSet<>());
        }
        for(int i = 1; i<=8; i++){
            num = num * 10 + N;
            dp.get(i).add(num);
        }
        for(int i = 1; i<=8; i++){
            Set<Integer> current = dp.get(i);
            if(current.contains(number)){
                return i;
            }
            for(int k = 1; k<i; k++){
                Set<Integer> setA = dp.get(k);
                Set<Integer> setB = dp.get(i-k);
                if(setA == null || setB == null) continue;
                for(Integer a : setA){
                    for(Integer b : setB){
                        if(a == 0 || b == 0) continue;
                        current.add(a+b);
                        current.add(a-b);
                        current.add(a*b);
                        current.add(a/b);
                        if(b!=0) current.add(a/b);
                        if(a!=0) current.add(b/a);
                    }
                }

            }
            if(current.contains(number)){
                return i;
            }
        }
        return -1;
    }
}