class Solution {
    public int solution(int n) {
        int ans = 0;
        for(int i = 1; i<n; i++){
            if(n % i == 1) return i;
        }
        return 0;
    }
}