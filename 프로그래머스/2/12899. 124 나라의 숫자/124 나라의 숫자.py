def solution(n):
    ternary = ''
    while n:
        n, r = divmod(n, 3)
        if r == 0:
            n -= 1
        ternary = '412'[r] + ternary
    return ternary 