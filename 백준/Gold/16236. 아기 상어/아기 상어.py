import sys
from collections import deque

input = sys.stdin.readline

def BFS(graph, start, N):
    directions = [(-1, 0), (0, -1), (0, 1), (1, 0)]  # 위, 왼쪽, 오른쪽, 아래 순서
    shark_size = 2
    eat_cnt = 0
    total_time = 0

    def find_fish():
        queue = deque([(start[0], start[1], 0)])  # (x, y, 거리)
        visited = set([(start[0], start[1])])
        fish = []  # 먹을 수 있는 물고기 목록 (거리, x, y)

        while queue:
            x, y, dist = queue.popleft()
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < N and 0 <= ny < N and (nx, ny) not in visited:
                    visited.add((nx, ny))
                    if graph[nx][ny] <= shark_size:
                        queue.append((nx, ny, dist + 1))
                        if 0 < graph[nx][ny] < shark_size:
                            fish.append((dist + 1, nx, ny))

        # 거리가 가까운 순, 가장 위쪽, 가장 왼쪽 우선으로 정렬
        fish.sort()
        return fish[0] if fish else None

    while True:
        result = find_fish()
        if result is None:
            break  # 더 이상 먹을 수 있는 물고기가 없으면 종료

        dist, x, y = result
        total_time += dist
        eat_cnt += 1
        graph[x][y] = 0  # 물고기를 먹음

        # 상어 크기만큼 물고기를 먹으면 성장
        if eat_cnt == shark_size:
            shark_size += 1
            eat_cnt = 0

        # 시작 위치를 새 위치로 갱신
        start = (x, y)

    return total_time

if __name__ == "__main__":
    N = int(input().strip())
    fish = [list(map(int, input().split())) for _ in range(N)]

    # 상어의 시작 위치 찾기
    for i in range(N):
        for j in range(N):
            if fish[i][j] == 9:
                fish[i][j] = 0  # 시작 위치 초기화
                start = (i, j)

    print(BFS(fish, start, N))
