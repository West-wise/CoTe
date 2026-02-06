#include <bits/stdc++.h>
using namespace std;

string ans;
unordered_set<string> visited;

void dfs(string num, int depth, int max_depth)
{
    if (depth == max_depth)
    {
        ans = max(ans, num);
        return;
    }
    
    string state = num + "_" + to_string(depth);
    if (visited.count(state)) return;
    visited.insert(state);
    
    int n = num.size();
    
    // 모든 교환 가능한 쌍을 시도
    for (int i = 0; i < n - 1; i++)
    {
        for (int k = i + 1; k < n; k++)
        {
            swap(num[i], num[k]);
            dfs(num, depth + 1, max_depth);
            swap(num[i], num[k]); // 백트래킹
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int T, cnt = 1; 
    cin >> T;
    
    while (T--)
    {
        string num;
        int swap_cnt;
        cin >> num >> swap_cnt;
        
        ans = "";
        visited.clear();
        
        dfs(num, 0, swap_cnt);
        
        cout << "#" << cnt++ << " " << ans << "\n";
    }
    return 0;
}