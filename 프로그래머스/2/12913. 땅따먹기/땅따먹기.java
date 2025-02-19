import java.util.*;
class Solution {
    public int solution(int[][] land) {
        for(int i = 1; i < land.length; i++){
            for(int k = 0; k < land[i].length; k++){
                int maxPrev = 0;
                for(int j = 0; j < land[i].length; j++){
                    if(k == j) continue;
                    maxPrev = Math.max(maxPrev, land[i-1][j]);
                }
                land[i][k] += maxPrev;
            }
        }
        return Arrays.stream(land[land.length-1]).max().getAsInt();
    }
}