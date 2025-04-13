import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] array = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        long answer = 0;
        for(int idx = 0; idx < n; idx++){
            int left = 0;
            int right = array.length - 1;
            int target = array[idx];
            while(left < right){
                int tmp = array[left] + array[right];
                if(tmp == target){
                    if (left != idx && right != idx){
                        answer++;
                        break;
                    } else if (left == idx) {
                        left++;
                    } else {
                        right--;
                    }
                } else if(tmp > target){
                    right--;
                } else{
                    left++;
                }
            }
        }
        System.out.println(answer);
    }
}