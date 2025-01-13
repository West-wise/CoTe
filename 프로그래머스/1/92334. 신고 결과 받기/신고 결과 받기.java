import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String,Integer> receive = new HashMap<>();
        Map<String,HashSet<String>> send = new HashMap<>();


        // 한사람이 신고한 사람 정리(중복 제거)
        for(String ids : report){
            String[] id_arr = ids.split(" ");
            String sender = id_arr[0], receiver = id_arr[1];
            send.computeIfAbsent(sender, key -> new HashSet<>()).add(receiver);
        }

        // HashSet을 통해 중복이 제거된 각 사용자별로 신고된 횟수 체크
        for(HashSet<String> receiver : send.values()){
            for(String id : receiver){
                receive.put(id,receive.getOrDefault(id,0)+1);
            }
        }

        // 취합종료
        // 메일 보낼인원 정리
        ArrayList<String> mail_list = new ArrayList<>();
        for(String id : receive.keySet()){
            if(receive.get(id) >= k) mail_list.add(id);
        }

        HashMap<String,Integer> ans = new HashMap<>();
        for(String sender : send.keySet()){
            HashSet<String> tmp = send.get(sender);
            for(String target : mail_list){
                if(tmp.contains(target)){
                    ans.put(sender,ans.getOrDefault(sender,0)+1);
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(String id : id_list){
            answer.add(ans.getOrDefault(id,0));
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}