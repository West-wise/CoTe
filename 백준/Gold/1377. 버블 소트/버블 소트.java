import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int[][] array = new int[N][2];
        for (int i = 0; i <N; i++) {
            array[i] = new int[]{Integer.parseInt(input.readLine()), i};
        }
        int[][] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray, Comparator.comparingInt(a -> a[0]));

        int ans = 0;
        for(int i = 0; i <N; i++) {
            ans = Math.max(ans, sortedArray[i][1] - i);
        }
        System.out.println(ans+1);
    }
}