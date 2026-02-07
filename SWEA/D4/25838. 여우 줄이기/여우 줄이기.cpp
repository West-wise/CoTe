#include <bits/stdc++.h>
using namespace std;
int main(){
    int T; cin >> T;
    while (T--)
    {
        int N; cin >> N;
        string str; cin >> str;
        string ans = "";
        string fox = "fox";
        for (char c : str){
            ans.push_back(c);
            if (ans.size()>=3 && ans.back() == 'x'){
                bool match = true;
                for (int i = 0; i<3; i++)
                {
                    if (ans[ans.size() - 3 + i] != fox[i])
                    {
                        match = false;
                        break;
                    }
                }
                if (match)
                {
                    for (int i = 0; i<3; i++) ans.pop_back();
                }
            }
        }
        cout << ans.size() << "\n";
    }
    return 0;
}