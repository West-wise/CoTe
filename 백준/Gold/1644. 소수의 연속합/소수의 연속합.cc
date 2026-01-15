#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
void get_prime_set(vector<int>& prime_set, int N)
{
    vector<bool> seive(N+1,true);
    seive[0] = seive[1] = false;
    for (int i = 2; i * i <= N; i++)
    {
        if (!seive[i]) continue;
        for (int k = i*i; k<=N; k+=i) seive[k] = false;
    }
    for (int i = 2; i<=N; i++)
    {
        if (seive[i] != 0) prime_set.push_back(i);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N;
    cin >> N;
    vector<int> prime_set; prime_set.reserve(N+1);
    get_prime_set(prime_set, N+1);
    int left = 0, right = 0, ans = 0, sum = 0;
    int goal_size = (int)prime_set.size();
    while (true)
    {
        if (sum >= N)
        {
            if (sum == N) ans++;
            sum -= prime_set[left++];
        } else if (right == goal_size) break;
        else sum += prime_set[right++];
    }
    cout << ans;

    return 0;
}