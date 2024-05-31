class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] s = Long.toString(n,k).split("0");
        for(String num : s){
            if(is_prime(num)) answer++;
        }        
        return answer;
    }
    
    
    private static boolean is_prime(String num){
        //true => 소수
        //false => 소수 아님
        if(num.isEmpty()) return false; //각 자릿수에 0이 없어야함
        
        Long n = Long.valueOf(num); //10진수로 변환
        if(n<=1) return false;
        else if(n==2) return true;
        else{
            for(long i = 2; i <= Math.sqrt(n); i++) {
			    if(n % i == 0) {
				    return false;
			    }
		    }
        }
        
        return true;
    }    
}