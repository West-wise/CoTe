from collections import Counter


def solution(weights):
    answer = 0
    c = Counter(weights)
    for weight, count in c.items():
        if count >= 2:
            answer += count * (count - 1) // 2

    set_weights = set(weights)
    for weight in set_weights:
        if weight * 2 // 3 in set_weights:
            answer += c[weight * 2 / 3] * c[weight]
        if weight // 2 in set_weights:
            answer += c[weight/ 2] * c[weight]
        if weight * 3 // 4 in set_weights:
            answer += c[weight * 3 / 4] * c[weight]
    return answer