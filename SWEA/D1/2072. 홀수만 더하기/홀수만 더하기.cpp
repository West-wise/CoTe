#include<iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);
    int T;
    cin >> T;

    for(int cnt = 1; cnt<=T; cnt++){
   	 int sum = 0;
        for (int i = 0; i < 10; i++)
        {
            int num;
            cin >> num;
            if (num % 2 != 0) sum += num;
        }
        cout << "#" << cnt << " " << sum << "\n";
    }
    return 0;
}