import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 링크드 리스트와 스택..
        Stack<Integer> remove = new Stack<>();

        int[] prev = new int[n+2];
        int[] next = new int[n+2];

        for(int i=0; i<n+2; i++){
            prev[i] = i-1; // -1~8
            next[i] = i+1; // 1~10
        }
        int idx = k+1;

        for(String s : cmd){
            if(s.startsWith("C")){ //현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다
                remove.push(idx);
                prev[next[idx]] = prev[idx];
                next[prev[idx]] = next[idx];
                idx = next[idx] > n ? prev[idx] : next[idx];
            }else if(s.startsWith("Z")){ //가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
                int num = remove.pop(); // 인덱스 복구
                next[prev[num]] = num;
                prev[next[num]] = num;

            } else {
                String[] tmp = s.split(" ");
                String command = tmp[0];
                int num = Integer.parseInt(tmp[1]);
                for(int i=0; i<num; i++){
                    idx = command.equals("U") ? prev[idx] : next[idx];
                }
            }
        }
        StringBuilder result = new StringBuilder();
        result.append("O".repeat(n));
        for(int remove_index : remove){
            result.setCharAt(remove_index-1,'X');
        }
        return result.toString();
    }
}