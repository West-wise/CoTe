#include <iostream>
#include <string>
using namespace std;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string isbn;
    cin >> isbn;

    int isbn_sum = 0;
    int loss_weight = 0;
    int check_num = isbn[12] - '0';
    for (int i = 0; i<12; i++)
    {
        if (isbn[i] == '*')
        {
            loss_weight = (i%2 == 0) ? 1 : 3;
        } else
        {
            isbn_sum += (i%2==0) ? isbn[i]-'0' : 3*(isbn[i]-'0');
        }
    }

    for (int i = 0; i<10; i++)
    {
        int tmp = (isbn_sum + (loss_weight * i)) % 10;
        if (check_num == 0)
        {
            if (tmp == 0)
            {
                cout << i << endl;
                break;
            }
        } else if (10 - (tmp%10) == check_num)
        {
            cout << i << endl;
            break;
        }
    }
    return 0;
}