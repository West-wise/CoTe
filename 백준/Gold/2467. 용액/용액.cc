#include <iostream>
#include <vector>
#include <climits>
#include <iomanip>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int N;
    cin >> N;
    vector<int> liquid(N);
    for (int i = 0; i<N; i++) cin >> liquid[i];

    int right = N-1;
    int left = 0;
    pair<int, int> diff = {0,2'000'000'001};

    while (left < right)
    {
        int tmp = liquid[left] + liquid[right];
        if (tmp == 0)
        {
            diff = {liquid[left], liquid[right]};
            break;
        }
        int tmp2 = abs(diff.first+diff.second);
        if (tmp2 > abs(tmp)) diff = {liquid[left], liquid[right]};
        if (tmp < 0) left++;
        else right--;
    }
    cout << diff.first << " " << diff.second;
    return 0;
}