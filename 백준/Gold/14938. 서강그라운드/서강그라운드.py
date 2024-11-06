import sys
from collections import defaultdict, deque

import heapq

input = sys.stdin.readline

def Dijkstra(graph,start):
    distances = {node:float('inf') for node in graph}
    distances[start] = 0

    pq = []
    heapq.heappush(pq,(0,start))

    while pq:
        current_distance,current_node = heapq.heappop(pq)
        if current_distance > distances[current_node]:
            continue
        for neighbor, weight in graph[current_node]:
            distance = current_distance + weight
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(pq,(distance,neighbor))
    return distances


if __name__ == "__main__":
    n, m, r = map(int, input().split())

    t = list(map(int, input().split()))
    result = []
    graph = defaultdict(list)
    for _ in range(r):
        a, b, l = map(int, input().split())
        graph[a].append((b,l))
        graph[b].append((a,l))

    for key in range(1,n+1):
        tmp = Dijkstra(graph,key)
        tmpsum = 0
        for key in tmp.keys():
            if tmp[key] <= m:
                tmpsum += t[key-1]
        result.append(tmpsum)
    print(max(result))