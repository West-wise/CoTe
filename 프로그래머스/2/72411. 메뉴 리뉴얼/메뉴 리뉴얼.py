from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    for num in course:
        cnt = Counter("".join(sorted(c)) for order in orders for c in combinations(order, num))
        max_count = max(cnt.values(), default=0)
        answer.extend([menu for menu, count in cnt.items() if count == max_count and count > 1])
    return sorted(answer)
