def solution(storey):
    answer = 0
    while storey > 0:
        storey, digit = divmod(storey, 10)
        if digit > 5:
            answer += 10 - digit
            storey += 1
        elif digit < 5:
            answer += digit
        else:
            if storey % 10 + 1 > 5:
                answer += 10 - digit
                storey += 1
            else:
                answer += digit
    return answer 