import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] arr = new int[(elements.length)*2]; //2배짜리 배열 생성
        Set<Integer> set = new HashSet<>();
        
        int idx =0;
        for(int i=0; i<elements.length; i++){
            arr[i] = arr[i+elements.length] = elements[i];
        }
        
        //int sum =0;
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                        sum += arr[j + k];
                }
                set.add(sum);

            }
        }
        return set.size();
    }
}