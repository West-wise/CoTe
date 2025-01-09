import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> card_set1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> card_set2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayList<String> answer = new ArrayList<>();

        // 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다. -> 큐 사용
        // 한 번 사용한 카드는 다시 사용할 수 없습니다. -> pop 해야함
        // 카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다. -> 중요

        for(int i=0; i<goal.length; i++) {
            String goal_word = goal[i];
            if(!card_set1.isEmpty() && card_set1.peek().equals(goal_word)) {
                answer.add(card_set1.poll());
            } else if(!card_set2.isEmpty() && card_set2.peek().equals(goal_word)) {
                answer.add(card_set2.poll());
            } else { //
                return "No";
            }

        }
        if(answer.toString().equals(Arrays.toString(goal))){
            return "Yes";
        }
        return "No";
    }
}