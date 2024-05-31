from collections import deque


def BFS(graph, start, visited):
    N, M = len(graph), len(graph[0])
    q = deque([start])
    visited.add(start)
    total_sum = int(graph[start[0]][start[1]])
    direction = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    while q:
        x, y = q.popleft()
        for nx, ny in direction:
            dx, dy = x + nx, y + ny
            if 0 <= dx < N and 0 <= dy < M:
                if graph[dx][dy].isnumeric() and (dx, dy) not in visited:
                    visited.add((dx, dy))
                    total_sum += int(graph[dx][dy])
                    q.append((dx, dy))
    return total_sum


def solution(maps):
    answer = []
    coordinate = []
    visited = set()
    for x in range(len(maps)):
        maps[x] = list(maps[x])
        for y in range(len(maps[x])):
            if maps[x][y].isnumeric():
                coordinate.append((x, y))
    if len(coordinate) == 0:
        return [-1]
    for i in coordinate:
        if i in visited:
            continue
        answer.append(BFS(maps, i, visited))

    return sorted(answer)