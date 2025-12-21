import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int B = Integer.parseInt(br.readLine());
        int[] arrB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> answer = new ArrayList<>();
        int start_A = 0, start_B = 0;
        while(true){
            int maxVal = -1; // 공동 최대값
            int tempA = -1, tempB = -1;

            for(int i = start_A; i < A; i++){
                if(arrA[i] > maxVal){
                    for(int k = start_B; k < B; k++){
                        if(arrA[i] == arrB[k]){
                            maxVal = arrA[i];
                            tempA = i;
                            tempB = k;
                            break;
                        }
                    }
                }
            }
            if(maxVal == -1) break;
            answer.add(maxVal);
            start_A = tempA+1;
            start_B = tempB+1;
        }

        int size = answer.size();
        System.out.println(size);
        if(size!=0){
            StringBuilder sb = new StringBuilder();
            for(int i : answer){
                sb.append(i).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }

    }

}
