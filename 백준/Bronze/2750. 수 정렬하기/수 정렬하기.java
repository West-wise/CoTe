import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(array);
        for(int num : array) {
            System.out.println(num);
        }
    }
}