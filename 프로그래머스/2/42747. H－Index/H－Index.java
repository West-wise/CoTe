class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int max = 0;
        for(int i : arr) max = Math.max(max,i);
        
        for(int i=1; i<max; i++){
            int cnt=0;
            for(int k : arr){
                if(i<=k) cnt++;
            }
            if(i<=cnt){
                answer = Math.max(answer,i);
            }
        }
    
        
        return answer;
    }
    
    
}