import sys

INF = int(2000000000)
input = sys.stdin.readline

def bellman_ford(graph,start,node_num):
    
    distance = [INF] * (node_num+1)
    distance[start] = 0
    
    # 모든 간선을 순회하며 최단 거리 갱신
    for _ in range(len(graph)-1):
        for u,v,w in graph:
            if distance[u] + w < distance[v]:
                distance[v] = distance[u] + w
    # 음의 가중치가 있는지 한번 더 검사
    for u, v, w in graph:
        if distance[u] + w < distance[v]:
            return True
    return False

if __name__ == "__main__":
    TC = int(input())
    for _ in range(TC):
        N,M,W = map(int,input().split())
        road = []
        # 단 도로는 방향이 없으며 웜홀은 방향이 있다.
        for _ in range(M):
            S,E,T = map(int,input().split())
            
            road.append((S,E,T))
            if S != E:
                road.append((E,S,T))
            
        for _ in range(W):
            S,E,T = map(int,input().split())
            road.append((S,E,-T))
            
        print('YES') if bellman_ford(road,road[0][0],N) else print('NO')
        
        