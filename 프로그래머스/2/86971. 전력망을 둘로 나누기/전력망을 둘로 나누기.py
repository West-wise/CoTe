def dfs(node, graph, visited):
    visited.add(node)
    for next_node in graph[node]:
        if next_node not in visited:
            dfs(next_node, graph, visited)


def solution(n, wires):
    answer = float('inf')

    # 그래프 초기화
    graph = {i: [] for i in range(1, n + 1)}
    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)

    for a, b in wires:
        graph[a].remove(b)
        graph[b].remove(a)

        sub1, sub2 = set(), set()
        dfs(a, graph, sub1)
        dfs(b, graph, sub2)
        answer = min(answer, abs(len(sub1) - len(sub2)))

        # 다시 간선 추가
        graph[a].append(b)
        graph[b].append(a)

    return answer
