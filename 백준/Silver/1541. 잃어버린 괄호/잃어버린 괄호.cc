#include <iostream>
#include <vector>
#include <string>
#include <sstream>
using namespace std;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    string formula;
    cin >> formula;
    istringstream iss(formula);
    vector<string> formulas;
    vector<int> res;
    string line;

    while (getline(iss, line, '-'))
    {
        formulas.push_back(line);
    }
    for (const string& s : formulas)
    {
        int tmp = 0;
        if (s.find('+') != string::npos)
        {
            istringstream iss2(s);
            while (getline(iss2, line, '+'))
            {
                tmp += stoi(line);
            }
        } else
        {
            tmp = stoi(s);
        }
        res.push_back(tmp);
    }
    int answer = res[0];
    for (int i = 1; i < formulas.size(); i++)
    {
        answer -= res[i];
    }
    cout << answer << endl;
}