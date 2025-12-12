import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
INF = int(1e9)

# 버스 이동 비용
dist = [[INF]*(n+1) for _ in range(n+1)]

for _ in range(m):
    u, v, w = map(int, input().split())
    # u -> v 노선이 여러개 존재 가능 : 최솟값으로만 저장
    if dist[u][v] > w:
        dist[u][v] = w

# 시작접 == 도착점 일 경우 비용 0으로 초기화
for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j:
            dist[i][j] = 0

# 모든 거쳐가는 노드 확인 -> 최솟값으로 갱신
for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            dist[a][b] = min(dist[a][b], dist[a][k] + dist[k][b])

for i in range(1, n+1):
    for j in range(1, n+1):
        if dist[i][j] < INF:
            print(dist[i][j], end=' ')
        else:
            print(0, end=' ')
    print(end='\n')