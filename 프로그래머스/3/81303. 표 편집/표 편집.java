import java.util.*;

class Solution {

    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> remove = new Stack<>();
        int[] prev = new int[n];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1; //마지막 노드는 next가 없다
        int idx = k;

        for (String str : cmd) {
            char command = str.charAt(0);
            if (command == 'U') {
                int num = Integer.parseInt(str.substring(2));
                while (num-- > 0) {
                    idx = prev[idx];
                }
            } else if (command == 'D') {
                int num = Integer.parseInt(str.substring(2));
                while (num-- > 0) {
                    idx = next[idx];
                }
            } else if (command == 'C') {
                remove.push(idx);
                if (prev[idx] != -1) next[prev[idx]] = next[idx];
                if (next[idx] != -1) prev[next[idx]] = prev[idx];

                idx = (next[idx] != -1) ? next[idx] : prev[idx];
            } else if (command == 'Z') {
                int restore = remove.pop();
                if (prev[restore] != -1) next[prev[restore]] = restore;
                if (next[restore] != -1) prev[next[restore]] = restore;
            }
        }
        StringBuilder result = new StringBuilder("O".repeat(n));
        while (!remove.isEmpty()) {
            result.setCharAt(remove.pop(), 'X');
        }
        return result.toString();
    }
}