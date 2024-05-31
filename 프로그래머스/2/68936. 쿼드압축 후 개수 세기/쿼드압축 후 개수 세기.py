def check(arr, x, y, m):

    first = arr[x][y]
    for i in range(x, x + m):
        for k in range(y, y + m):
            if first != arr[i][k]:
                return False
    return True


def compress(arr, x, y, n, answer):
    if n == 1 or check(arr, x, y, n):
        answer[arr[x][y]] += 1
    else:
        m = n // 2
        compress(arr, x, y, m, answer)
        compress(arr, x, y + m, m, answer)
        compress(arr, x + m, y, m, answer)
        compress(arr, x + m, y + m, m, answer)


def solution(arr):
    answer = [0, 0]

    compress(arr, 0, 0, len(arr), answer)

    return answer