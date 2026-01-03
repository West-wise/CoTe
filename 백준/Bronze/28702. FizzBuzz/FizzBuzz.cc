#include <iostream>
#include <string>
using namespace std;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int hint = 0;
    int hint_idx = 0;
    for (int i = 0; i<3; i++)
    {
        string tmp;
        cin >> tmp;
        if (tmp[0] != 'F' && tmp[0] != 'B')
        {
            hint = stoi(tmp);
            hint_idx = i;
        }
    }
    string ans = "";
    for (int i = 0; i<3-hint_idx; i++)
    {
        hint++;
        if (hint%3 == 0 && hint%5 == 0)
        {
            ans = "FizzBuzz";
        } else if (hint%3==0 && hint%5!=0)
        {
            ans = "Fizz";
        } else if (hint%3!=0 && hint%5==0)
        {
            ans = "Buzz";
        } else
        {
            ans = to_string(hint);
        }
    }
    cout << ans << endl;
    return 0;
}