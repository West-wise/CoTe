from collections import deque

def BFS(graph):
    n, m = len(graph), len(graph[0])
    visited = [[False] * m for _ in range(n)]
    visited[0][0] = True
    direction = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    queue = deque([(0, 0, 1)])
    
    while queue:
        x, y, cnt = queue.popleft()
        if x == n - 1 and y == m - 1:
            return cnt
        for dx, dy in direction:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny, cnt + 1))
    return -1

def solution(maps):
    return BFS(maps)
