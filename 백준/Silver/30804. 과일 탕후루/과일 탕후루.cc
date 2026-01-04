#include <iostream>
#include <unordered_set>
#include <vector>
using namespace std;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    vector<int> fruits(N);
    for (int i = 0; i < N; i++) cin >> fruits[i];

    int slide_size = 1; // 일단 한종류만 있어도 되니까..
    // 매번 함수를 호출하는 대신, 메인 루프에서 상태 변수를 관리합니다.
    int left = 0, distinct_types = 0, max_len = 0;
    vector<int> counts(10, 0);

    for (int right = 0; right < N; right++) {
        // 1. 새로 들어온 과일 처리 (right)
        if (counts[fruits[right]] == 0) distinct_types++;
        counts[fruits[right]]++;

        // 2. 조건 위반 시(종류 > 2) 왼쪽을 당겨서 실시간으로 복구
        while (distinct_types > 2) {
            counts[fruits[left]]--;
            if (counts[fruits[left]] == 0) distinct_types--;
            left++;
        }

        // 3. 이 시점에서 윈도우는 무조건 '종류 2개 이하'를 만족함
        max_len = max(max_len, right - left + 1);
    }
    cout << max_len << endl;
    return 0;
}