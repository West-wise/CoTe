import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String,Integer> rankManager = new HashMap<>();
        Map<Integer,String> playerManager = new HashMap<>();
        for(int i=0; i<players.length; i++){
            rankManager.put(players[i],i);
            playerManager.put(i,players[i]);
        }
        for(String name : callings) {
            int idx = rankManager.get(name);
            int prevIdx = idx-1;

            String frontPlayer = playerManager.get(prevIdx);

            //교환 단계
            rankManager.put(name, prevIdx);
            rankManager.put(frontPlayer,idx);

            playerManager.put(prevIdx, name);
            playerManager.put(idx,frontPlayer);
        }

        for(int i=0; i<players.length; i++){
            answer[i] = playerManager.get(i);
        }

        return answer;
    }
}