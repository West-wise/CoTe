class Solution {
    public int solution(int n, int w, int num) {
        int height = n%w == 0 ? n/w : n/w + 1;
        int[][] boxStack = new int[height][w];
        int cnt = 1;
        for(int i=0; i < boxStack.length; i++) {
            if(i % 2== 0){
                for(int k =0; k<w; k++){
                    boxStack[i][k] = cnt;
                    cnt = cnt >= n || cnt == 0 ? 0 : cnt + 1;
                }
            } else{
                for(int k = w-1; k>=0; k--){
                    boxStack[i][k] = cnt;
                    cnt = cnt >= n || cnt == 0 ? 0 : cnt + 1;
                }
            }

        }
        int idx = 0;
        int start = 0;
        for(int i=0; i<boxStack.length; i++){
            for(int k=0; k<w; k++){
                if(boxStack[i][k] == num){
                    idx = k;
                    start = i;
                    break;
                }
            }
        }
        int answer = 0;
        for(int i = start; i<boxStack.length; i++){
            if(boxStack[i][idx] != 0){
                answer++;
            }
        }

        return answer;
    }
}