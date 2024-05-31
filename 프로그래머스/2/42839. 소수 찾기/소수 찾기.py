import math
from itertools import permutations


def is_primenum(x):
    if x < 2:
        return False
    for i in range(2, int(math.sqrt(x) + 1)):
        if x % i == 0:
            return False
    return True


def solution(numbers):
    answer = set()
    for r in range(1, len(numbers) + 1):
        perms = permutations(numbers, r)

        for perm in perms:
            num = int("".join(perm))
            answer.add(num)
    ans = 0
    for num in list(answer):
        if is_primenum(num):
            ans += 1
    return ans