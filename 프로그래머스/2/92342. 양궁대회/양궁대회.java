import java.util.*;
class Solution {
    public static void combi(int[] nums, int index, int[] combination, int n, List<int[]> result){
        if(Arrays.stream(combination).sum() == n){
            result.add(Arrays.copyOf(combination, combination.length));
            return;
        }
        if(Arrays.stream(combination).sum() > n ){return;}
        for(int i = index; i<nums.length; i++){
            combination[nums[i]]++;
            combi(nums, i, combination, n, result);
            combination[nums[i]]--;
        }
    }
    public int selectCombi(int[] info, int[] arr){
        int apeach = 0, rian = 0;
        for(int i=10; i>=0; i--){
            int score_a = info[10-i], score_r = arr[10-i];
            if(score_a == 0 && score_r == 0){continue;}
            if(score_a >= score_r){
                apeach += i;
            } else {
                rian += i;
            }
        }
        return rian - apeach;
    }

    public int[] solution(int n, int[] info) {
        int max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            for (int i = 10; i >= 0; i--) {
                if (a[i] != b[i]) return b[i] - a[i]; // 낮은 점수 많이 맞힌 순
            }
            return 0;
        });
        List<int[]> combinations = new ArrayList<>();
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        combi(nums, 0, new int[11], n, combinations);
        for (int[] combination : combinations) {
//            System.out.println(Arrays.toString(combination));
            int diff = selectCombi(info, combination);
            if(diff > max){
                max = diff;
                pq.clear();
                pq.add(combination);
            } else if(diff == max){
                pq.add(combination);
            }
        }
        int[] answer = pq.isEmpty() ? new int[]{-1} : pq.poll();
        if(max == 0) answer = new int[]{-1};
        return answer;
    }
}