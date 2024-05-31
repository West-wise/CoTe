import heapq
from collections import defaultdict


def Dijkstra(graph, K):
    # 모든 노드를 무한대로 초기화
    distance = {node: float("inf") for node in graph}
    distance[1] = 0
    queue = []
    heapq.heappush(queue, [distance[1], 1])

    while queue:
        current_distance, current_node = heapq.heappop(queue)

        if current_distance > distance[current_node]:
            continue

        for neighbor, weight in graph[current_node]:
            dist = current_distance + weight

            if dist < distance[neighbor]:
                distance[neighbor] = dist
                heapq.heappush(queue, [dist, neighbor])
    answer = []
    for i in distance:
        if distance[i] <= K:
            answer.append(i)
    return len(answer)


def solution(N, road, K):
    graph = defaultdict(list)
    for a, b, t in road:
        graph[a].append((b, t))
        graph[b].append((a, t))
    return Dijkstra(graph, K)
