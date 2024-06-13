import sys

input = sys.stdin.readline


def DFS(graph, x, y, visited, depth):
    global answer
    answer = max(answer, depth)
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    char = graph[x][y]
    visited[ord(char) - 65] = True

    for dx, dy in directions:
        nx, ny = x + dx, y + dy
        if 0 <= nx < R and 0 <= ny < C:
            char = graph[nx][ny]
            if not visited[ord(char) - 65]:
                DFS(graph, nx, ny, visited, depth + 1)
                visited[ord(char) - 65] = False


if __name__ == "__main__":
    R, C = map(int, input().split())

    graph = [list(input().strip()) for _ in range(R)]
    visited = [False] * 26
    answer = 0
    DFS(graph, 0, 0, visited, 1)

    print(answer)
