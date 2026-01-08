#include <iostream>
#include <vector>
#include <climits>
#include <iomanip>
using namespace std;

inline void compare_diff(pair<int, int>& diff, pair<int, int> li)
{
    int tmp1 = abs(diff.second + diff.first);
    int tmp2 = abs(li.second + li.first);
    if (tmp1 > tmp2) diff = li;
}

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
    pair<int, int> diff = {0,INT_MAX};

    while (left < right)
    {
        int tmp = liquid[left] + liquid[right];
        if (tmp == 0)
        {
            diff = {liquid[left], liquid[right]};
            break;
        }
        compare_diff(diff, {liquid[left], liquid[right]});
        if (tmp < 0) left++;
        else right--;
    }
    cout << diff.first << " " << diff.second;
    return 0;
}