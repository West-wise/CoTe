import java.util.*;
class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int widthLimit = board[0]/2;
        int heightLimit = board[1]/2;
        int[] now = {0, 0};
        Map<String,int[]> keySet = new HashMap<>();
        keySet.put("left",new int[]{-1,0});
        keySet.put("right",new int[]{1,0});
        keySet.put("up",new int[]{0,1});
        keySet.put("down",new int[]{0,-1});

        for(String dir : keyinput){
            int[] tmp = keySet.get(dir);
            if(dir.equals("up") || dir.equals("down")){
                if(Math.abs(now[1] + tmp[1]) <=heightLimit){
                    now[1] += tmp[1];
                }
            } else{
                if(Math.abs(now[0] + tmp[0]) <= widthLimit){
                    now[0] += tmp[0];
                }
            }
        }
        return now;
    }
}