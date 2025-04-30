import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for(int num : list){
            result.append(num).append("\n");
        }
        System.out.println(result);
    }
}
