import copy


def matrix_mul(matrix, rev):
    result = []
    rev_matrix = list(zip(*rev))
    for row in matrix:
        tmp_list = []
        for col in rev_matrix:
            tmp_list.append(sum(a * b for a, b in zip(row, col)) % 1000)
        result.append(tmp_list)
    return result


def matrix_pow(matrix, b):
    if b == 1:
        return [[elem % 1000 for elem in row] for row in matrix]

    if b % 2 == 0:
        half = matrix_pow(matrix, b // 2)
        return matrix_mul(half, half)
    else:
        return matrix_mul(matrix, matrix_pow(matrix, b - 1))


if __name__ == "__main__":
    N, B = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(N)]
    result = matrix_pow(matrix, B)

    for row in result:
        print(" ".join(str(value) for value in row))
