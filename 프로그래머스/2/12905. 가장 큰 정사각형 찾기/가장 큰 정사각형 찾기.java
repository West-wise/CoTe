class Solution
{
    public int solution(int [][]board)
    {
        int rows = board.length, cols = board[0].length;

        if(rows == 1 || cols == 1) return 1;
        int max = 0;
        for(int i = 1; i < rows; i++){
            for(int k = 1; k < cols; k++){
                if(board[i][k] >= 1){
                    board[i][k] = Math.min(board[i-1][k], Math.min(board[i-1][k-1], board[i][k-1])) + 1;
                }
                max = Math.max(max, board[i][k]);
            }
        }
        return max * max;
    }
}