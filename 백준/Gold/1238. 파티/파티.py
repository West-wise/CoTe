import sys
import heapq
import math

input = sys.stdin.readline
INF = float('inf')

N, M, X = map(int, input().split())


def dijkstra(graph, start):
    distance = {vertex: INF for vertex in range(1, N + 1)}
    distance[start] = 0
    pq = [(0, start)]

    while pq:
        current_distance, current_vertex = heapq.heappop(pq)
        if current_distance > distance[current_vertex]:
            continue
        for neighbor_node, weight in graph.get(current_vertex, []):
            new_distance = current_distance + weight
            if new_distance < distance[neighbor_node]:
                distance[neighbor_node] = new_distance
                heapq.heappush(pq, (new_distance, neighbor_node))

    return distance


graph = {i: [] for i in range(1, N + 1)}

for i in range(M):
    start, end, cost = map(int, input().split())
    graph[start].append((end, cost))

tmp2 = dijkstra(graph, X)
max_value = 0

for i in graph.keys():
    if i == X:
        continue
    tmp = dijkstra(graph, i)
    max_value = max(max_value, tmp2[i] + tmp[X])

print(max_value)
