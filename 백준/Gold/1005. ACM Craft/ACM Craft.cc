#include <cstdio>
#include <algorithm>

using namespace std;

// 1. Fast I/O: 정수만 빠르게 읽기
inline int readInt() {
    int n = 0;
    char c = getchar_unlocked();
    while (c < '0' || c > '9') c = getchar_unlocked();
    while (c >= '0' && c <= '9') {
        n = n * 10 + (c - '0');
        c = getchar_unlocked();
    }
    return n;
}

const int MAXN = 1005;     // 건물 최대 개수
const int MAXK = 100005;   // 도로 최대 개수

int build_time[MAXN];
int indegree[MAXN];
int dp[MAXN];
int q[MAXN];

// 2. Forward Star (정적 인접 리스트)
int head[MAXN], to[MAXK], nxt[MAXK], edge_cnt;

void add_edge(int u, int v) {
    to[edge_cnt] = v;
    nxt[edge_cnt] = head[u];
    head[u] = edge_cnt++;
}

void solve() {
    int N = readInt();
    int K = readInt();

    // 초기화 (memset보다 루프가 가독성/성능상 유리할 수 있음)
    edge_cnt = 0;
    for (int i = 1; i <= N; i++) {
        build_time[i] = readInt();
        head[i] = -1;
        indegree[i] = 0;
        dp[i] = 0;
    }

    for (int i = 0; i < K; i++) {
        int u = readInt();
        int v = readInt();
        add_edge(u, v);
        indegree[v]++;
    }

    int W = readInt();

    // 3. Array-based Queue
    int front = 0, rear = 0;
    for (int i = 1; i <= N; i++) {
        if (indegree[i] == 0) {
            q[rear++] = i;
            dp[i] = build_time[i];
        }
    }

    while (front < rear) {
        int cur = q[front++];

        // 4. 정적 리스트 순회 (캐시 효율 최적화)
        for (int i = head[cur]; i != -1; i = nxt[i]) {
            int next = to[i];
            
            // 점화식 최적화 (분기 예측 고려)
            int next_time = dp[cur] + build_time[next];
            if (next_time > dp[next]) dp[next] = next_time;

            if (--indegree[next] == 0) {
                q[rear++] = next;
            }
        }
    }

    printf("%d\n", dp[W]);
}

int main() {
    int T = readInt();
    while (T--) {
        solve();
    }
    return 0;
}