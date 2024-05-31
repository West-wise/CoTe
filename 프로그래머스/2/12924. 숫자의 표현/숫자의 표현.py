def solution(n):
    answer = 1
    for i in range(1,int(n/2)+1):
        tmp = 0
        for k in range(i,n):
            tmp += k
            if tmp == n:
                answer += 1
                continue
            elif tmp>n:
                break

    return answer