class Solution {
    public int[] solution(long n) {
        
        int exp = (int) Math.log10(n) + 1;
        int[] answer = new int[exp];
        for(int i = 0; i < exp; i++){
            answer[i] = (int)(n % 10);
            n/=10;
        }
        
        return answer;
    }
}