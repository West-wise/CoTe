import java.util.*;

class Solution {

    List<String> answer = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> airport = new HashMap<>();

        for(String[] ticket : tickets) {
            airport.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        dfs(airport, "ICN");
        Collections.reverse(answer);
        return answer.toArray(new String[0]);
    }

    private void dfs(Map<String, PriorityQueue<String>> airport, String start){
        PriorityQueue<String> queue = airport.get(start);
        while(queue != null && !queue.isEmpty()) {
            dfs(airport, queue.poll());
        }
        answer.add(start);
    }
}