import time
from collections import deque


def solution(bridge_length, weight, truck_weights):
    answer = 0
    q = deque()
    truck_weights = deque(truck_weights)

    while truck_weights or q:
        if q:
            if q[0][1] + bridge_length <= answer:
                q.popleft()

        if truck_weights:
            if sum([truck[0] for truck in q]) + truck_weights[0] <= weight:
                q.append([truck_weights.popleft(), answer])

        answer += 1
    return answer
