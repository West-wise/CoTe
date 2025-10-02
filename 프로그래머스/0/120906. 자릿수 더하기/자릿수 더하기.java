class Solution {
    public int solution(int n) {
        int res = 0;
        for(int i = 10; i < n*10; i*=10){
            res += (n%i) / (i/10);
        }
        return res;
    }
}