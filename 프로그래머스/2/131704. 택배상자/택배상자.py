def solution(order):
    answer = 0
    stack = []
    for i in range(1, len(order) + 1):
        stack.append(i)
        while stack and stack[-1] == order[answer]:
            stack.pop()
            answer += 1
    return answer