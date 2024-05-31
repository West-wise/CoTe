def solution(m, n, board):
    answer = 0
    tmp_board = [list(row) for row in board]

    # m = 가로, n = 세로
    while True:
        explode = set()
        for x in range(m-1):
            for y in range(n-1):
                if tmp_board[x][y] != tmp_board[x + 1][y + 1] != "-":
                    continue
                if tmp_board[x][y] == tmp_board[x + 1][y] == tmp_board[x][y + 1] != "-":
                    explode |= {(x, y), (x + 1, y), (x, y + 1), (x + 1, y + 1)}

        if not explode:
            break

        # 터진 블록 갯수 추가
        answer += len(explode)

        # 터진 블록을 -로 변경
        for i, j in explode:
            tmp_board[i][j] = "-"
        # 블록을 아래로 내리기
        for y in range(n):
            for x in range(m - 1, 0, -1):
                if tmp_board[x][y] == "-":
                    for k in range(x - 1, -1, -1):
                        if tmp_board[k][y] != "-":
                            tmp_board[x][y], tmp_board[k][y] = (
                                tmp_board[k][y],
                                tmp_board[x][y],
                            )
                            break
    return answer