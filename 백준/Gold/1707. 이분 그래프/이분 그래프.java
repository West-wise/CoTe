import java.io.*;
import java.util.*;
public class Main {
    public static int N, M;
    public static int[] color;
    public static boolean status;
    public static void isBipartiteGraph(int node, Map<Integer,List<Integer>> map, int colors){
        color[node] = colors; // 1 : red, -1 : blue, 0 : 색칠 안됨
        List<Integer> list = map.get(node);
        if(list!=null){
            for(int i : list){
                if(color[i] == colors){
                    status = false;
                    return;
                }
                if(color[i] == 0){
                    isBipartiteGraph(i,map, -colors);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> map;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(input.readLine());
            int nodeCnt = Integer.parseInt(st.nextToken());
            int edgeCnt = Integer.parseInt(st.nextToken());
            map = new HashMap<>();
            color = new int[nodeCnt+1];
            status = true;
            for(int j =0; j<=nodeCnt; j++){
                map.putIfAbsent(j, new ArrayList<>());
            }
            for(int k = 0; k<edgeCnt; k++){
                st = new StringTokenizer(input.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                map.get(start).add(end);
                map.get(end).add(start);
            }
            for(int idx = 1;  idx<=nodeCnt; idx++){
                if(!status) break;
                if(color[idx] == 0) isBipartiteGraph(idx, map, 1);
            }
            System.out.println(status ? "YES" : "NO");
        }
    }
}