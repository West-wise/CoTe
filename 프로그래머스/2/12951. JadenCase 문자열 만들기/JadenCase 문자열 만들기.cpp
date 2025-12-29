#include <string>
#include <cctype>

using namespace std;

string solution(string s) {
    bool isFirst = true;

    for (char &c : s) {
        if (c == ' ') {
            isFirst = true;
        } else {
            if (isFirst) {
                c = toupper((unsigned char)c);
                isFirst = false;
            } else {
                c = tolower((unsigned char)c);
            }
        }
    }
    return s;
}