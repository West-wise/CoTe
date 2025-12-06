import java.util.*;
class Solution {
    public int[] solution(int[][] data){
        int n = data.length;
        // 0: 노드 번호, 1: 도넛, 2: 막대, 3: 8자
        int[] answer = new int[4];
        Map<Integer, int[]> graph = new HashMap<>(); // node, [in, out]
        for(int[] node : data){
            graph.computeIfAbsent(node[0], k->new int[2])[1]+=1;
            graph.computeIfAbsent(node[1], k->new int[2])[0]+=1;
        }

        for(int key : graph.keySet()){
            int[] val = graph.get(key);
            int in = val[0];
            int out = val[1];
            if(in == 0 && out >= 2) answer[0] = key;
            else if(out == 0 && in >= 1) answer[2]++;
            else if(out >= 2 && in >= 2) answer[3]++;
        }
        answer[1] = graph.get(answer[0])[1] - answer[2] - answer[3];
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}