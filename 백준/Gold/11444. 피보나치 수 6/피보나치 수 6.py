import sys

MOD = 1000000007


def fibonacci(number, memo=None):
    if memo is None:
        memo = {}
    if number in memo:
        return memo[number]
    if number <= 1:
        return number
    elif number == 2:
        return 1

    if number % 2 == 0:  # 짝수
        result = (
            fibonacci(number // 2, memo)
            * (fibonacci(number // 2 + 1, memo) + fibonacci(number // 2 - 1, memo))
        ) % MOD
    else:  # 홀수
        result = (
            fibonacci((number + 1) // 2, memo) ** 2
            + fibonacci((number - 1) // 2, memo) ** 2
        ) % MOD

    memo[number] = result
    return result


if __name__ == "__main__":
    num = int(input())
    print(fibonacci(num))
