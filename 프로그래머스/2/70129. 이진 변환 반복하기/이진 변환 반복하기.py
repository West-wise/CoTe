def solution(s):
    answer = []
    arr = s
    cnt = 0
    stack = 0
    
    while len(str(arr)) > 1:
        stack += str(arr).count('0')
        num = str(arr).count('1')
        arr = int(bin(num)[2:])
        cnt += 1
        
    answer.append(cnt)
    answer.append(stack)
    return answer
