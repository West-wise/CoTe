import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       String numbers = input.readLine();
       int[] arr = new int[numbers.length()];
       for(int i = 0; i<arr.length; i++){
           arr[i] = Character.getNumericValue(numbers.charAt(i));
       }
       StringBuilder result = new StringBuilder();
       Arrays.sort(arr);
       for(int i = arr.length-1; i>=0; i--){
           result.append(arr[i]);
       }
       System.out.println(result);
    }
}