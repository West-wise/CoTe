from collections import deque


def BFS(start, end):
    queue = deque()
    queue.append((start, 0))
    visited = {start: 0}
    time = float("inf")
    cnt = 0
    while queue:
        current_node, current_time = queue.popleft()
        if current_node == end:
            if current_time < time:
                time = current_time
                cnt = 1
            elif current_time == time:
                cnt += 1
            continue
        for next_node in (current_node - 1, current_node + 1, current_node * 2):
            if 0 <= next_node <= 100000:
                if next_node not in visited or current_time + 1 <= visited[next_node]:
                    visited[next_node] = current_time + 1
                    queue.append((next_node, current_time + 1))

    print(time)
    print(cnt)


if __name__ == "__main__":
    n, k = map(int, input().split())
    if n > k:
        print(n - k)
        print(1)
    else:
        BFS(n, k)
