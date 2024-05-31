def check(arr):
    res = [-1] * len(arr)
    stack = []

    for i in range(len(arr) - 1, -1, -1):
        while stack and arr[i] >= stack[-1]:
            stack.pop()
        if stack:
            res[i] = stack[-1]
        stack.append(arr[i])

    return res

def solution(numbers):
    answer = []
    answer = check(numbers)
    return answer