#include <iostream>
#include <vector>
#include <cmath>
using namespace std;


void get_prime_set(vector<int>& prime_set, int N)
{
    vector<int> seive(N+1,0);
    for (size_t i = 2; i<seive.size(); i++) seive[i] = (int)i;
    for (int i = 2; i<=sqrt(seive.size()); i++)
    {
        if (seive[i] == 0) continue;
        for (int k = i*i; k<(int)seive.size(); k+=i) seive[k] = 0;
    }
    for (size_t i = 2; i<seive.size(); i++)
    {
        if (seive.at(static_cast<int>(i)) != 0) prime_set.push_back(seive[i]);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N;
    cin >> N;
    vector<int> prime_set; prime_set.reserve(N+1);
    get_prime_set(prime_set, N+1);
    int left = 0, right = 0, ans = 0;
    int sum = prime_set[0];
    while (left <= right &&  right < N)
    {
        if (sum == N) ans++;
        if (sum < N) sum += prime_set[++right];
        else sum -= prime_set[left++];
    }
    cout << ans;

    return 0;
}