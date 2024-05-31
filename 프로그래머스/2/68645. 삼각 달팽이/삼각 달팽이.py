def solution(n):
    answer = []
    last_num = (n*(n+1)//2)

    triangle = [[0] * i for i in range(1,n+1)]

    num = 1
    x,y = -1,0
    for i in range(n):
        for j in range(i, n):
            #아래로 이동
            if i % 3 == 0:
                x += 1
            # 옆으로 이동
            elif i % 3 == 1:
                y += 1
            # 위로 이동
            else:
                x -= 1
                y -= 1
            triangle[x][y] = num
            num += 1

    for ele in triangle:
        answer+=ele

    return answer
