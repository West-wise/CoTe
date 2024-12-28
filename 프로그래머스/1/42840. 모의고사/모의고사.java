import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        Map<Integer,Integer> player = new HashMap<>();
        int[][] pattern = {
                {1,2,3,4,5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
        };
        int[] src = new int[3];
        // answer = {1,2,3,4,5}
        // 근데 여기서 고려해야할 것은 answer와 각 pattern의 길이가 다를 수도 있다는 것이다.
        for(int i=0; i<answers.length; i++){
            for(int k=0; k<pattern.length; k++){
                if(answers[i] == pattern[k][i%pattern[k].length]){
                    src[k]++;
                }
            }
        }
        int max = Arrays.stream(src).max().getAsInt();

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i<src.length; i++){
            if(src[i] == max){
                ans.add(i+1);
            }
        }

        return ans.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }
}