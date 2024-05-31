def solution(sequence, k):
    answer = []
    res = []
    diff = float("inf")
    left = right = 0
    arr_sum = 0

    while right < len(sequence):
        arr_sum += sequence[right]
        while arr_sum >= k:
            if arr_sum == k:
                answer.append([left, right])
            arr_sum -= sequence[left]
            left += 1
        right += 1
    if len(answer) == 1:
        return answer[0]
    else:
        for each in answer:
            if each[-1] - each[0] < diff:
                diff = each[-1] - each[0]
                res = each

        return res