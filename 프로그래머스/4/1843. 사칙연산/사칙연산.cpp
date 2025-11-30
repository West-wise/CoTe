#include <vector>
#include <string>
#include <climits>
#include <algorithm>
using namespace std;

int solution(vector<string> arr)
{
    // 방어적 프로그래밍: null-like 체크
    if (arr.empty()) {
        return 0;  // 안전 처리
    }

    int num_cnt = arr.size() / 2 + 1;

    // DP 테이블 생성
    vector<vector<int>> max_dp(num_cnt, vector<int>(num_cnt, INT_MIN));
    vector<vector<int>> min_dp(num_cnt, vector<int>(num_cnt, INT_MAX));

    // 숫자 초기화
    for (int i = 0; i < num_cnt; i++) {
        int val = stoi(arr[i * 2]);
        max_dp[i][i] = val;
        min_dp[i][i] = val;
    }

    // DP 구간 확장
    for (int len = 1; len < num_cnt; len++) {
        for (int i = 0; i < num_cnt - len; i++) {

            int j = i + len;

            for (int k = i; k < j; k++) {

                string op = arr[k * 2 + 1];

                if (op == "+") {
                    if (max_dp[i][k] != INT_MIN && max_dp[k+1][j] != INT_MIN)
                        max_dp[i][j] = max(max_dp[i][j], max_dp[i][k] + max_dp[k+1][j]);
                    if (min_dp[i][k] != INT_MAX && min_dp[k+1][j] != INT_MAX)
                        min_dp[i][j] = min(min_dp[i][j], min_dp[i][k] + min_dp[k+1][j]);

                } else if (op == "-") {
                    // max = left max - right min
                    if (max_dp[i][k] != INT_MIN && min_dp[k+1][j] != INT_MAX)
                        max_dp[i][j] = max(max_dp[i][j], max_dp[i][k] - min_dp[k+1][j]);

                    // min = left min - right max
                    if (min_dp[i][k] != INT_MAX && max_dp[k+1][j] != INT_MIN)
                        min_dp[i][j] = min(min_dp[i][j], min_dp[i][k] - max_dp[k+1][j]);
                }
            }
        }
    }

    return max_dp[0][num_cnt - 1];
}
