import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    private static boolean check_map(Map<Character, Integer> map){
        for(char key : map.keySet()){
            if(map.get(key) > 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int answer = 0;
        String str = input.readLine();

        Map<Character, Integer> map = new HashMap<>();
        char[] dna = {'A', 'C', 'G', 'T'};
        st = new StringTokenizer(input.readLine());
        for(int i =0; i<4; i++){
            map.put(dna[i], Integer.parseInt(st.nextToken()));
        }
        Queue<Character> queue = new LinkedList<>();
        // 첫 윈도우에 대해서 연산 수행
        for(int i = 0; i<p; i++){
            char c = str.charAt(i);
            queue.add(c);
            map.put(c, map.get(c)-1);
        }
        if(check_map(map))answer++;


        for(int i = p; i<s; i++){
            char removeChar = queue.poll(); // 윈도우의 맨 앞글자 제거
            if(map.containsKey(removeChar)){
                map.put(removeChar, map.get(removeChar)+1);
            }
            char c = str.charAt(i);
            queue.add(c);
            if(map.containsKey(c)){
                map.put(c, map.get(c) -1);
                if(check_map(map)){
                    answer++;
                }
            }

        }
        System.out.println(answer);
    }
}