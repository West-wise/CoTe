import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int answer = 0;
        for(int i = 1; i<=n; i++){
            int tmp =n - (i*(i-1)) / 2;
            if(tmp<=0) break;
            if(tmp % i == 0) answer++;
        }
        System.out.println(answer);
    }
}