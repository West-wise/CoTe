def solution(A, B):
    answer = 0

    for i, k in zip(sorted(A), reversed(sorted(B))):
        answer += i * k

    return answer