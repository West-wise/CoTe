import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String[] inputArr = input.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int time = Integer.parseInt(inputArr[i]);
            arr[i] = time;
        }
        Arrays.sort(arr);
        int tmp = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            tmp = tmp + arr[i];
            result += tmp;
        }
        System.out.println(result);

    }
}