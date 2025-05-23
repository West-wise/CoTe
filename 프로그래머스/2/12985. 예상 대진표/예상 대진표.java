class Solution
{
    public int solution(int n, int a, int b)
    {
        // 항상 이긴다고 가정
        // 부전승 없음
        int answer = 1;

        while(Math.abs(a-b) != 1 || a/2 == b/2){
            a = a%2 == 0 ? a/2 : a/2+1;
            b = b%2 == 0 ? b/2 : b/2+1;
            answer++;
        }
        return answer;
    }
}