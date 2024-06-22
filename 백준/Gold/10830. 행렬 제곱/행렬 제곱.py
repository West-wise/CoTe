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
    half = matrix_pow(matrix, b // 2)
    half_squared = matrix_mul(half, half)
    if b % 2 == 0:
        return half_squared
    else:
        return matrix_mul(half_squared, matrix)


def get_transposed_matrix(matrix, N):
    return [[col[i] for col in matrix] for i in range(N)]


if __name__ == "__main__":
    N, B = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(N)]
    flag = False if B % 2 == 0 else True
    result = matrix_pow(matrix, B)
    for row in result:
        print(" ".join(str(value) for value in row))
