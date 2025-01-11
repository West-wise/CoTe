import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String,String> msg = Map.of(
                "Enter","님이 들어왔습니다.",
                "Leave", "님이 나갔습니다."
        );

        Map<String,String> map = new HashMap<>();
        for(String cmd : record) {
            String[] tmp = cmd.split(" ");
            if(tmp.length == 3){ // Enter or Change
                map.put(tmp[1],tmp[2]); // uid : name
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        for(String cmd : record){
            String[] log = cmd.split(" ");
            if(log[0].equals("Enter") || log[0].equals("Leave")){
                String tmp = map.get(log[1]).concat(msg.get(log[0]));
                ans.add(tmp);

            }
        }
        return ans.toArray(new String[0]);
    }
}