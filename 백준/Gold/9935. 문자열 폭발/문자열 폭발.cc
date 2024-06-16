#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;



std::string solution(string word, string bomb){
    char bomb_last = bomb[bomb.length() -1];
    int blen = bomb.length();
    vector<char> stack;

    for (auto c : word){
        stack.push_back(c);
        if (stack.size() >= blen && stack.back() == bomb_last){
            if (std::string(stack.end() - blen, stack.end())== bomb){
                for(auto c2 : bomb){
                    stack.pop_back();
                }
            }
        }
    }

    std::string answer = "FRULA";

    if (!stack.empty()){
        answer = std::string(stack.begin(),stack.end());
    }

    return answer;
}

int main(){
    std::string word,bomb;
    getline(cin,word);
    getline(cin,bomb);

    cout << solution(word,bomb) << endl;

    return 0;
}