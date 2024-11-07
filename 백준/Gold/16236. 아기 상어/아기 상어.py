import sys
from collections import deque

input = sys.stdin.readline

def BFS(graph, start, N):
    directions = [(-1, 0), (0, -1), (0, 1), (1, 0)]
    shark_size = 2
    eat_cnt = 0
    sec = 0
    def find_fish_cordinate():
    # 물고기는 1.위쪽 2.왼쪽 순서로 우선순위를 정한다.
        queue = deque([(start[0], start[1], 0)])  # (x, y, 거리)
        visited = set([(start[0], start[1])])
        fish_list = []

        while queue:
            x,y,distance = queue.popleft()
            for dx,dy in directions:
                nx,ny = x+dx,y+dy
                if 0 <= nx < N and 0<=ny<N and (nx,ny) not in visited:
                    if graph[nx][ny] <= shark_size:
                        queue.append((nx,ny,distance+1))
                        visited.add((nx, ny))
                        if 0 < graph[nx][ny] < shark_size:
                            fish_list.append((distance+1,nx,ny))
        fish_list.sort()
        return fish_list[0] if fish_list else None

    while True:
        result = find_fish_cordinate()
        if result is None:
            break
        distance, x,y = result
        sec += distance
        eat_cnt += 1
        graph[x][y] = 0
        if eat_cnt == shark_size:
            shark_size+=1
            eat_cnt = 0
        start = (x,y)
    return sec
if __name__ == "__main__":
    N = int(input().strip())
    fish = [list(map(int, input().split())) for _ in range(N)]
    for i in range(N):
        for k in range(N):
            if fish[i][k] == 9:
                fish[i][k] = 0 # 시작 위치 초기화.
                start = (i,k)
    print(BFS(fish, start, N))