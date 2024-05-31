class Solution
{
    public int solution(int n, int a, int b)
    {
        //단, A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정합니다.
        int answer = 1; //1라운드부터 시작
 
        while(Math.abs(a - b) != 1 || a / 2 == b / 2){
            a = div(a);
            b = div(b);
            answer++;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(b);

        return answer;
    }
    
    private static int div(int num){
        if(num==1)return num;
        return (num%2==0) ? num/2 : num/2+1;
    }
}