import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int m = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = n-1;
        int answer = 0;
        Arrays.sort(array);

        while(left < right){
            int tmp = array[left] + array[right];
            if(tmp == m) {
                answer++;
                left++;
                right--;
            }
            else if (tmp < m) {
                left++;
            } else{
                right--;
            }
        }
        System.out.println(answer);

    }
}