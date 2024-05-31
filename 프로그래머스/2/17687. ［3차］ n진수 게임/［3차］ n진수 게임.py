def convert(n,decimal):
    arr = "0123456789ABCDEF"
    q , r = divmod(decimal,n)
    if q == 0:
        return arr[r]
    else:
        return convert(n,q) + arr[r]

def solution(n, t, m, p):
    answer = ''
    nlist = ''

    for i in range(t*m):
        nlist += convert(n,i)

    for i in range(p-1,t*m,m):
        answer += nlist[i]

    return answer