from collections import deque

def bfs_air(board, n, m):
    queue = deque([(0, 0)])
    air = [[False] * m for _ in range(n)]
    air[0][0] = True
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    while queue:
        x, y = queue.popleft()
        
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and not air[nx][ny] and board[nx][ny] == 0:
                air[nx][ny] = True
                queue.append((nx, ny))
    
    return air

def melt_cheese(board, air, n, m):
    melt_positions = []
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    for i in range(n):
        for j in range(m):
            if board[i][j] == 1:
                contact_count = 0
                for dx, dy in directions:
                    ni, nj = i + dx, j + dy
                    if 0 <= ni < n and 0 <= nj < m and air[ni][nj]:
                        contact_count += 1
                if contact_count >= 2:
                    melt_positions.append((i, j))
    
    for i, j in melt_positions:
        board[i][j] = 0

    return len(melt_positions) > 0

def cheese_melting_time(board, n, m):
    time = 0
    
    while True:
        air = bfs_air(board, n, m)
        if not melt_cheese(board, air, n, m):
            break
        time += 1
    
    return time

if __name__ == "__main__":
    n, m = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]
    print(cheese_melting_time(board, n, m))
