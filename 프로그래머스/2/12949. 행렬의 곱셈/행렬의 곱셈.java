class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length]; //매트릭스 크기 설정
        
        
        for(int i=0; i<answer.length; i++){
            for(int k = 0; k<answer[0].length; k++){
                for(int t = 0; t<arr1[0].length; t++){
                    answer[i][k] += arr1[i][t] * arr2[t][k];
                }

            }
        }
        
        
        return answer;
    }
}