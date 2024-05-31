import sys
from collections import deque

input = sys.stdin.readline

def dfs(graph, start, visited):
    visited.add(start)
    max_node, max_distance = start, 0
    
    for next_node, distance in graph[start]:
        if next_node not in visited:
            next_max_node, next_max_distance = dfs(graph, next_node, visited)
            if next_max_distance + distance > max_distance:
                max_distance = next_max_distance + distance
                max_node = next_max_node
                
    return max_node, max_distance

if __name__ == "__main__":
    V = int(input())
    graph = {i: [] for i in range(1, V + 1)}
    
    for _ in range(V):
        data = list(map(int, input().split()))
        node = data[0]
        
        # DEQUE 사용 부분 수정
        edges = deque((data[i], data[i + 1]) for i in range(1, len(data) - 1, 2))
        
        while edges:
            next_node, distance = edges.popleft()
            graph[node].append((next_node, distance))
            graph[next_node].append((node, distance))
            
    start_node, _ = dfs(graph, next(iter(graph.keys())), set())
    _, result = dfs(graph, start_node, set())
    
    print(result)
