#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    vector visited(n, false);
    unordered_map<int, vector<pair<int,int>>> map;
    priority_queue<pair<int,int>, vector<pair<int, int>>, greater<>> pq;

    for (const auto& cost : costs)
    {
        int from = cost[0], to = cost[1], c = cost[2];
        map[from].emplace_back(c,to);
        map[to].emplace_back(make_pair(c, from));
    }

    pq.emplace(0,0);
    while (!pq.empty())
    {
        pair<int, int> cur = pq.top(); pq.pop();
        int cost = cur.first, node = cur.second;
        if (visited[node]) continue;
        visited[node] = true;
        answer += cost;
        for (const auto& next : map[node])
        {
            int next_cost = next.first, next_node = next.second;
            if (!visited[next_node]) pq.emplace(next_cost, next_node);
        }

    }

    return answer;
}