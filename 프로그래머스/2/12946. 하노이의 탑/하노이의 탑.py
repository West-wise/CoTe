def hanoi(n, src_tower, dst_tower, sub_tower, answer):
    if n == 1:
        return answer.append([src_tower, dst_tower])
    hanoi(n - 1, src_tower, sub_tower, dst_tower, answer)
    answer.append([src_tower, dst_tower])
    hanoi(n - 1, sub_tower, dst_tower, src_tower, answer)


def solution(n):
    answer = []
    hanoi(n, 1, 3, 2, answer)
    return answer