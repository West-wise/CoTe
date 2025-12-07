#include <iostream>
#include <vector>
#include <queue>
#include <stdexcept>

using namespace std;

class BuildingScheduler {
private:
    int n;
    vector<int> cost;
    vector<int> indegree;
    vector<int> dp;
    vector<vector<int>> graph;

public:
    BuildingScheduler(int count) : n(count), cost(count + 1), indegree(count + 1), dp(count + 1), graph(count + 1) {
        if (count <= 0) {
            throw invalid_argument("노드 개수는 1 이상이어야 합니다.");
        }
    }

    void setCost(int idx, int value) {
        if (idx < 1 || idx > n) return;
        cost[idx] = value;
        dp[idx] = value;
    }

    void addDependency(int prev, int next) {
        if (prev < 1 || prev > n || next < 1 || next > n) return;
        graph[prev].push_back(next);
        indegree[next]++;
    }

    vector<int> calculate() {
        queue<int> q;

        for (int i = 1; i <= n; ++i) {
            if (indegree[i] == 0) q.push(i);
        }

        if (q.empty()) {
            throw runtime_error("모든 노드가 의존 관계를 가지고 있어 정렬이 불가능합니다.");
        }

        while (!q.empty()) {
            int cur = q.front();
            q.pop();

            for (int next : graph[cur]) {
                dp[next] = max(dp[next], dp[cur] + cost[next]);
                if (--indegree[next] == 0) q.push(next);
            }
        }

        return dp;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int cnt;
    cin >> cnt;

    BuildingScheduler scheduler(cnt);

    for (int i = 1; i <= cnt; i++) {
        int time;
        cin >> time;
        scheduler.setCost(i, time);

        while (true) {
            int x;
            cin >> x;
            if (x == -1) break;
            scheduler.addDependency(x, i);
        }
    }

    vector<int> result = scheduler.calculate();

    for (int i = 1; i <= cnt; i++) {
        cout << result[i] << "\n";
    }

    return 0;
}
