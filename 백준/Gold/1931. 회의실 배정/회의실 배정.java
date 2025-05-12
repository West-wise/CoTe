import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        List<int[]> arr = new ArrayList<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.add(new int[]{start, end});
        }

        Collections.sort(arr, new Comparator<int[]> (){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]){
                    return Integer.compare(o1[1],o2[1]);
                } else{
                    return Integer.compare(o1[0],o2[0]);
                }
            }
        });

        int end_time = arr.get(0)[1];
        arr.remove(0);
        int result = 1;
        for(int[] tmp : arr){
            if(end_time <= tmp[0]){
                result++;
                end_time = tmp[1];
            }
        }
        System.out.println(result);

    }
}