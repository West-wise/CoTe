import java.util.*;

public class Main {


    public static int[] LDS(ArrayList<Integer> array, int n){
        int [] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=n-2; i>-1; i--){
            for (int k=n-1; k>i; k--){
                if (array.get(k) < array.get(i)){
                    dp[i] = Math.max(dp[i],dp[k] +1);
                }
            }
        }
        return dp;
    }

    public static int[] LIS(ArrayList<Integer> array, int n){
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i=0; i<n; i++){
            for (int k=0; k<i; k++){
                if(array.get(k) < array.get(i)){
                    dp[i] = Math.max(dp[i],dp[k]+1);
                }
            }
        }

        return dp;
    }
    public static int solution(ArrayList<Integer> array, int n){
        ArrayList<Integer> answer = new ArrayList<>();
        int [] dp_inc = LIS(array,n);
        int [] dp_dec = LDS(array,n);

        for (int i=0; i<n; i++){
            answer.add(dp_inc[i] + dp_dec[i] - 1);
        }
        return Collections.max(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i=0; i<N; i++){
            array.add(sc.nextInt());
        }

        System.out.println(solution(array,N));
        sc.close();
    }
}
