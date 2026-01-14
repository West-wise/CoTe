#include <iostream>
#include <vector>

using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N;
    cin >> N;
    vector<int> pos(1000001, 0), answer(1000001,0);
    vector<int> card(N);

    for (int i = 0; i<N; i++) {
        cin >> card[i];
        pos[card[i]]=1;
    }
    for (int i = 0; i<N; i++) {
        int cur_num = card[i];
        for (int k = cur_num; k<=1000000; k+= cur_num) {
            if (k == cur_num) continue; // 내 카드는 스킵
            if (pos[k] != 0) { // cur_num의 배수가 존재
                answer[cur_num]++;
                answer[k]--;
            }
        }
    }
    for (int val : card) {
        cout << answer[val] << " ";
    }

    return 0;
}