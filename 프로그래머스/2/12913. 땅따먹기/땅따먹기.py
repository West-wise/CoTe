def solution(land):
    for i in range(1, len(land)):
        for k in range(4):
            land[i][k] += max(land[i - 1][:k] + land[i - 1][k + 1 :])
    return max(land[-1])