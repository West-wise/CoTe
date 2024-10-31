import sys
from collections import defaultdict

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def dfs(graph, start, visited):
    visited.add(start)
    dist_sum = 0
    last_node = start
    for node, distance in graph[start]:
        if node not in visited:
            next_node, total = dfs(graph, node, visited)
            total += distance
            if total > dist_sum:
                dist_sum = total
                last_node = next_node
    return last_node, dist_sum


def main():
    graph = defaultdict(list)
    # 1~V까지
    V = int(input())  # 2 ≤ V ≤ 100,000
    for i in range(1, V + 1):
        arr = list(map(int, input().split()))
        arr = arr[:-1]
        key = arr.pop(0)
        for k in range(0, len(arr), 2):
            graph[key].append((arr[k], arr[k + 1]))

    farthest, _ = dfs(graph, 1, set())
    print(dfs(graph, farthest, set())[1])


if __name__ == "__main__":
    main()
