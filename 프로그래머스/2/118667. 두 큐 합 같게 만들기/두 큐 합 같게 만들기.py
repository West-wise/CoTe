from collections import deque

def pop_queue(pop_q, append_q):
    item = pop_q.popleft()
    append_q.append(item)
    return item


def solution(queue1, queue2):
    answer = 0

    queue1, queue2 = deque(queue1), deque(queue2)
    sum_q1, sum_q2 = sum(queue1), sum(queue2)
    stop = len(queue1) + len(queue2)
    stop *= 2
    while True:
        if sum_q1 == 0 or sum_q2 == 0 or answer > stop:
            return -1
        if sum_q1 > sum_q2:
            pop_item = pop_queue(queue1, queue2)
            sum_q1 -= pop_item
            sum_q2 += pop_item
        elif sum_q1 < sum_q2:
            pop_item = pop_queue(queue2, queue1)
            sum_q2 -= pop_item
            sum_q1 += pop_item
        else:
            return answer
        answer += 1