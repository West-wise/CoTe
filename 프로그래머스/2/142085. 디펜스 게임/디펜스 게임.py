import heapq
import sys

input = sys.stdin.readline

def solution(n, k, enemy):

    if k >= len(enemy):
        return len(enemy)

    answer = 0
    queue = []

    for i in range(len(enemy)):
        heapq.heappush(queue, enemy[i])
        if len(queue) > k:
            last = heapq.heappop(queue)
            if last > n:
                return i
            n -= last
    return len(enemy)