import sys
import heapq
import math
from collections import defaultdict

input = sys.stdin.readline

def Dijkstra(graph, start):
    distance = {vertex: math.inf for vertex in range(1, V+1)}
    distance[start] = 0
    pq = [(0, start)]  # 튜플 순서 변경
    
    while pq:
        current_distance, current_vertex = heapq.heappop(pq)  # 튜플 순서 변경
        if current_distance > distance[current_vertex]:
            continue
        for neighbor_node, weight in graph.get(current_vertex, []):
            new_distance = current_distance + weight
            if new_distance < distance[neighbor_node]:
                distance[neighbor_node] = new_distance
                heapq.heappush(pq, (new_distance, neighbor_node))
                
    return distance

if __name__ == "__main__":
    V, E = map(int, input().split())
    root = int(input())
    graph = defaultdict(list)
    
    for _ in range(E):
        u, v, w = map(int, input().split())
        graph[u].append((v, w))  # (vertex, weight)
        
    res = Dijkstra(graph, root)

    for i in range(1, V+1):
        if res[i] == math.inf:
            print("INF")
        elif res[i] == 0:
            print(0)
        else:
            print(res[i])
