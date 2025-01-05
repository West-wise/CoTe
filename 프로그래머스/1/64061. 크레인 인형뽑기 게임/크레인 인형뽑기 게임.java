import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        ArrayList<Stack<Integer>> boardStack = new ArrayList<>();

        for(int i=0; i<board.length; i++){
            Stack<Integer> tmp = new Stack<>();
            for(int k=board.length-1; k >=0; k--){
                if(board[k][i] != 0){
                    tmp.push(board[k][i]);
                }
            }
            boardStack.add(tmp);
        }
        for(int move : moves){
            int num = move-1;
            Stack<Integer> tmp = boardStack.get(num);
            if (!tmp.isEmpty()) {
                int popNum = tmp.pop();
                if(!bucket.isEmpty() && bucket.peek() == popNum){
                    bucket.pop();
                    answer+=2;
                }else{
                    bucket.push(popNum);
                }
            }
        }
        return answer;
    }
}