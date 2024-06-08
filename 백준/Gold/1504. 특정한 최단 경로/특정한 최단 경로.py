import heapq
import sys
from collections import defaultdict, deque

input = sys.stdin.readline


def Dijkstra(graph, start, dst):

    #
    distance = {node: float("inf") for node in graph}
    distance[start] = 0
    queue = []
    heapq.heappush(queue, [distance[start], start])

    while queue:
        current_distance, current_node = heapq.heappop(queue)
        if current_distance > distance[current_node]:
            continue

        for neighbor, weight in graph[current_node]:
            dist = current_distance + weight
            if dist < distance[neighbor]:
                distance[neighbor] = dist
                heapq.heappush(queue, [dist, neighbor])
    return distance[dst]


if __name__ == "__main__":

    N, E = map(int, input().split())
    graph = defaultdict(list)
    answer = []
    for _ in range(E):
        a, b, c = map(int, input().split())

        # 양방향 그래프
        graph[a].append((b, c))
        graph[b].append((a, c))

    # 반드시 거쳐야하는 두 점.
    V1, V2 = map(int, input().split())
    dir1 = 0
    dir2 = 0

    try:
        # 1. 1번노드에서 정점 V1을 목적지로하는 다익스트라.
        dir1 += Dijkstra(graph, 1, V1)
        #     1-1 V1정점에서 V2를 목적지로 하는 다익스트라.
        dir1 += Dijkstra(graph, V1, V2)
        #     1-2 V2정점에서 정점 N을 목적지로 하는 다익스트라
        dir1 += Dijkstra(graph, V2, N)

        # 2. 1번노드에서 V2를 목적지로 하는 다익스트라.
        dir2 += Dijkstra(graph, 1, V2)
        #     2-1 V2정점에서 V1을 목적지로 하는 다익스트라.
        dir2 += Dijkstra(graph, V2, V1)
        #     2-2 V1정점에서 N을 목적지로 하는 다익스트라
        dir2 += Dijkstra(graph, V1, N)
        result = min(dir1, dir2)

        # 최단 경로가 없는 경우 처리
        if result == float("inf"):
            print(-1)
        else:
            print(result)
    except:
        print(-1)
    
