#pragma GCC optimize("O3,unroll-loops")
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// Fast I/O: 정수 입력을 극한으로 빠르게 읽기
inline int readInt() {
    int n = 0;
    bool neg = false;
    char c = getchar_unlocked();
    while (c != '-' && (c < '0' || c > '9')) c = getchar_unlocked();
    if (c == '-') { neg = true; c = getchar_unlocked(); }
    while (c >= '0' && c <= '9') {
        n = n * 10 + (c - '0');
        c = getchar_unlocked();
    }
    return neg ? -n : n;
}

int main() {
    // 이미 Fast I/O를 쓴다면 cin.tie는 필요 없지만 습관적으로 넣어준다.
    int N = readInt();
    vector<int> liquid(N);
    for (int i = 0; i < N; i++) liquid[i] = readInt();

    int left = 0, right = N - 1;
    int ans_l = liquid[left], ans_r = liquid[right];
    long long min_diff = abs((long long)ans_l + ans_r);

    while (left < right) {
        long long current_sum = (long long)liquid[left] + liquid[right];
        long long current_diff = abs(current_sum);

        // 최솟값 갱신: pair 객체 생성 없이 변수에 직접 기록
        if (current_diff < min_diff) {
            min_diff = current_diff;
            ans_l = liquid[left];
            ans_r = liquid[right];
            if (min_diff == 0) break; // 0이면 더 이상 볼 필요 없음
        }

        // 포인터 이동
        if (current_sum < 0) left++;
        else right--;
    }

    // printf가 cout보다 미세하게 빠를 수 있다.
    printf("%d %d\n", ans_l, ans_r);
    return 0;
}