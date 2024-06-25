import heapq
import sys
from collections import defaultdict

input = sys.stdin.readline

INF = float("inf")


def Dijkstra(graph, start, end):
    distance = {vertex: INF for vertex in range(1, n + 1)}
    pre_node = {}
    visited = set()  # 방문 처리를 위한 집합 추가
    distance[start] = 0
    pq = [(0, start)]

    while pq:
        current_distance, current_vertex = heapq.heappop(pq)

        if current_vertex in visited:  # 이미 방문한 노드는 스킵
            continue
        visited.add(current_vertex)  # 방문 처리

        if current_distance > distance[current_vertex]:
            continue

        for neighbor_node, weight in graph.get(current_vertex, []):
            new_distance = current_distance + weight
            if new_distance <= distance[neighbor_node]:
                distance[neighbor_node] = new_distance
                pre_node[neighbor_node] = current_vertex
                heapq.heappush(pq, (new_distance, neighbor_node))

    path = []
    step = end
    while step is not start:
        path.append(step)
        step = pre_node[step]
    path.append(start)
    path.reverse()

    print(distance[end])
    print(len(path))
    print(" ".join(map(str, path)))


if __name__ == "__main__":
    n = int(input())
    m = int(input())
    graph = defaultdict(list)
    for _ in range(m):
        start_node, end_node, cost = map(int, input().split())
        graph[start_node].append((end_node, cost))

    start, end = map(int, input().split())
    Dijkstra(graph, start, end)
