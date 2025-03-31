import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2 * w + 1; // 하나의 기지국이 커버할 수 있는 범위
        int lastCovered = 0; // 마지막으로 커버된 아파트 번호

        for (int station : stations) {
            int left = station - w;
            int right = station + w;

            // 이전 기지국과 현재 기지국 사이의 빈 공간 계산
            if (lastCovered + 1 < left) {
                int gap = left - (lastCovered + 1);
                answer += (gap + range - 1) / range; // 나눗셈 올림 처리
            }

            // 현재 기지국이 커버하는 범위 업데이트
            lastCovered = right;
        }

        // 마지막 기지국 이후 남은 빈 공간 처리
        if (lastCovered < n) {
            int gap = n - lastCovered;
            answer += (gap + range - 1) / range;
        }

        return answer;
    }
}
