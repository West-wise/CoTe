def border_update(matrix, coner_set):
    coner1, coner2, coner3, coner4 = coner_set
    # (1, 1) (1, 3) (4, 3) (4, 1)
    border = []
    # Top
    border.extend(matrix[coner1[0]][coner1[1] : coner2[1] + 1])

    # Right Down
    for i in range(coner2[0] + 1, coner3[0]):
        border.append(matrix[i][coner3[1]])

    # Bottom
    for i in range(coner3[1], coner4[1] - 1, -1):
        border.append(matrix[coner3[0]][i])

    # Left Up
    for i in range(coner4[0] - 1, coner1[0], -1):
        border.append(matrix[i][coner1[1]])

    tmp_arr = border[-1:] + border[:-1]
    index = 0
    # Top Update
    for i in range(coner1[1], coner2[1] + 1):
        matrix[coner1[0]][i] = tmp_arr[index]
        index += 1

    # Right Update
    for i in range(coner2[0] + 1, coner3[0]):
        matrix[i][coner3[1]] = tmp_arr[index]
        index += 1

    # Bottom Update
    for i in range(coner3[1], coner4[1] - 1, -1):
        matrix[coner3[0]][i] = tmp_arr[index]
        index += 1

    # Left Updtae
    for i in range(coner4[0] - 1, coner1[0], -1):
        matrix[i][coner1[1]] = tmp_arr[index]
        index += 1

    return border


def solution(rows, columns, queries):
    answer = []

    box = []
    for k in range(rows):
        box.append([i + k * columns for i in range(1, columns + 1)])

    for query in queries:
        coner1 = (query[0] - 1, query[1] - 1)
        coner2 = (query[0] - 1, query[3] - 1)
        coner3 = (query[2] - 1, query[3] - 1)
        coner4 = (query[2] - 1, query[1] - 1)
        conser_set = [coner1, coner2, coner3, coner4]
        arr = border_update(box, conser_set)
        answer.append(min(arr))

    return answer