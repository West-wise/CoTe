import java.util.*;
public class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long processed = 0;

            for (int t : times) {
                processed += mid / t;
                if (processed >= n) break; // 오버플로우 방지용 조기 탈출
            }

            if (processed >= n) {
                answer = mid;   // n명 이상 처리 가능 → 시간 줄여보기
                right = mid - 1;
            } else {
                left = mid + 1; // 처리 인원이 부족 → 시간 늘리기
            }
        }

        return answer;
    }
}