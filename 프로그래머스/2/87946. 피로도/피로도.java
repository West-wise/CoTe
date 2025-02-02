import java.util.*;
class Solution {

    public static void permutation(int[][] num, boolean[] used, List<int[]> current, List<List<int[]>> result) {
        if (current.size() == num.length) {
            result.add(new ArrayList<>(current)); // 순열을 저장
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) continue; // 이미 사용한 숫자는 건너뛴다.
            used[i] = true;
            current.add(num[i]); // 숫자를 추가
            permutation(num, used, current, result);
            current.remove(current.size() - 1); // 마지막 요소 제거
            used[i] = false; // 백트래킹
        }
    }

    public int solution(int k, int[][] dungeons) {
        // k = 현재 피로도
        int answer = 0;
        List<List<int[]>> result = new ArrayList<>();

        permutation(dungeons, new boolean[dungeons.length], new ArrayList<>(), result);

        for(List<int[]> perm : result){
            int tmp = 0;
            int k2 = k;
            for(int[] arr : perm){
                int need = arr[0], cost = arr[1];
                if(k2>= need){
                    tmp++;
                    k2 -= cost;
                }
            }
            answer = Math.max(answer, tmp);

        }

        return answer;
    }
}