import sys
from collections import deque
from itertools import combinations
import copy

input = sys.stdin.readline

# 1. 벽을 세움(더도말고 덜도말고, 딱 3개를 세워야함)
# 2. 바이러스가 퍼짐(1로 감싸진 부분을2로 치환)
# 3. 안전영역 계산

def zero_cordinate(graph,N,M):
    zero_space = [(i,k) for i in range(N) for k in range(M) if graph[i][k] ==0]
    return combinations(zero_space,3)

def standing_wall(graph,cordinate):
    tmp_arr = copy.deepcopy(graph)
    for x,y in cordinate:
        tmp_arr[x][y] = 1
    return tmp_arr


def virus_spread(graph,N,M):
    queue = deque([(i,k) for i in range(N) for k in range(M) if graph[i][k]==2])
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    while queue:
        x,y = queue.popleft()
        for nx, ny in directions:
            dx,dy = x+nx, y+ny
            if 0<=dx<N and 0<=dy<M and graph[dx][dy]==0:
                graph[dx][dy] = 2
                queue.append((dx,dy))


def count_safe_area(graph):
    return sum(res.count(0) for res in graph)

if __name__ == "__main__":
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    zero_list = zero_cordinate(arr,N,M)
    result = 0

    for codi in zero_list:
        step1 = standing_wall(arr,codi)
        virus_spread(step1,N,M)
        result = max(result, count_safe_area(step1))
    print(result)