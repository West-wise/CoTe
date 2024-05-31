def solution(numbers):
    answer = []
    for number in numbers:
        if number % 2 == 0:
            answer.append(number + 1)
        else:
            last_zero = number & -number
            next_number = number + last_zero
            right_ones = number ^ next_number
            right_ones = (right_ones // last_zero) >> 2
            answer.append(next_number | right_ones)
    return answer