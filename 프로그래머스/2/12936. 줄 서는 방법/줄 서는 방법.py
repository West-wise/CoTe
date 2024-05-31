import math
from itertools import permutations


def solution(n, k):
    arr = [i for i in range(1, n + 1)]
    start_arr = []
    remain = k

    while remain > 0:
        n -= 1
        if n == 0 or remain % math.factorial(n) == 0:
            break
        start_idx, remain = divmod(remain, math.factorial(n))
        start_arr.append(arr[start_idx])
        arr.pop(start_idx)
    last = list(permutations(arr, len(arr)))
    # print(last[remain - 1])
    start_arr.extend(list(last[remain - 1]))
    return start_arr