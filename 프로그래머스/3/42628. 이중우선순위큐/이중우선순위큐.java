import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st;
        for(String operation : operations){
            st = new StringTokenizer(operation);
            String op = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            if(op.equals("I")){
                set.add(number);
            } else if (op.equals("D") && !set.isEmpty()) {
                if(number > 0){
                    set.pollLast();
                } else {
                    set.pollFirst();
                }
            }
        }
        return set.isEmpty() ? new int[]{0,0} : new int[]{set.last(), set.first()};
    }
}