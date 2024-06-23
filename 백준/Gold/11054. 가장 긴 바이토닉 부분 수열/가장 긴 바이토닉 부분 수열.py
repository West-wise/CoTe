
from sys import stdin

input = stdin.readline


def LDS(array, n):
    dp = [1] * n
    for i in range(n - 2, -1, -1):
        for k in range(n - 1, i, -1):
            if array[k] < array[i]:
                dp[i] = max(dp[i], dp[k] + 1)
    return dp


def LIS(array, n):
    dp = [1] * n
    for i in range(n):
        for k in range(i):
            if array[k] < array[i]:
                dp[i] = max(dp[i], dp[k] + 1)
    return dp


def bitonic_sequence(n, array):

    dp_inc = LIS(array, n)
    dp_dec = LDS(array, n)
    answer = [dp_inc[i] + dp_dec[i] - 1 for i in range(n)]

    return max(answer)


if __name__ == "__main__":
    N = int(input())

    S = list(map(int, input().split()))
    """
    10
    1 5 2 1 4 3 4 5 2 1
    7
    (1,2,3,4,5,2,1)이렇게 길이가 7인 부분수열이 답.
    """

    print(bitonic_sequence(N, S))
