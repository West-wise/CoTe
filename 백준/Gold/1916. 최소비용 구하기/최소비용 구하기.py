import sys
import heapq
input = sys.stdin.readline

def Dijkstra(graph,root,end):
    
    S = graph.keys()
    distance = {vertex: float('inf') for vertex in range(1, len(S)+1)}
    distance[root] = 0
    
    pq = [(0,root)]
    
    while pq:
        current_distance, current_vertex = heapq.heappop(pq)
        
        if current_distance > distance[current_vertex]:
            continue
        
        for neighbor_node, weight in graph.get(current_vertex,[]):
            new_distance = current_distance + weight
            
            if new_distance < distance[neighbor_node]:
                distance[neighbor_node] = new_distance
                heapq.heappush(pq,(new_distance,neighbor_node))
                
    return distance[end]

def main():
    N = int(input())  # 도시의 갯수
    M = int(input())  # 버스의 갯수 

    graph = {i:[] for i in range(1,N+1)}
    
    for _ in range(M):
        source, destination, weight = map(int, input().split())
        if source not in graph:
            graph[source] = []
        graph[source].append((destination, weight))

    start, end = map(int, input().split())  # 구간 출발점의 도시번호, 도착번호

    
    print(Dijkstra(graph,start,end))

if __name__ == "__main__":
    main()
