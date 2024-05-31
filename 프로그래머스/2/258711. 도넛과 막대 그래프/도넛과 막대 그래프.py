from collections import defaultdict
def solution(edges):
    answer = []
    shapes = {'start': 0, 'donut': 0, 'stick': 0, 'loop': 0}
    edge_cnt = {'in': 0, 'out': 0}
    graph = defaultdict(lambda: edge_cnt.copy())

    for start, end in edges:
        graph[start]['out'] += 1
        graph[end]['in'] += 1


    for node in graph:

        in_edge = graph[node]['in']
        out_edge = graph[node]['out']

        if in_edge == 0 and out_edge >= 2:
            shapes['start'] = node
        elif out_edge == 0 and in_edge >= 1:
            shapes['stick'] += 1
        elif in_edge >= 2 and out_edge >= 2:
            shapes['loop'] += 1

    shapes['donut'] = graph[shapes['start']]['out'] - shapes['stick'] - shapes['loop']


    for node in shapes:
        answer.append(shapes[node])

    return answer