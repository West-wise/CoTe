import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] line = input.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        String[] inputArr = input.readLine().split(" ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) pq.add(Integer.parseInt(inputArr[i]));
        for(int i = 0; i<m-1; i++) pq.poll();
        System.out.println(pq.poll());
    }
}