import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        Arrays.sort(arr); //오름차순 정렬
        
        if(arr.length == 1) return arr[0];
        
        for(int i=1; i<arr.length; i++){
            int k = gcd(answer,arr[i]);
            answer = answer * arr[i] / k;
        }       
        return answer;
    }
    private static int gcd(int x, int y){
        if(y==0) return x;
        else return gcd(y,x%y);
    }
    
}