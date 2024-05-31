class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow; 
        for(int i=3; i<=brown; i++){
            if(sum%i==0){
                int k = sum/i;
                if(i>=k && (i-2)*(k-2)==yellow){
                    answer[0] = i;
                    answer[1] = k;
                    break;
                }
            }
        }
        return answer;
    }
}