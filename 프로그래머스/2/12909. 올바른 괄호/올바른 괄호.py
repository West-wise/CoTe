def solution(s):
    if s[0]==')': return False
    answer = True
    
    arr = []
    
    for i in s:
        if i=='(':
            arr.append(i)
        else:  # i == ')'
            if len(arr) == 0: return False
            else: arr.pop()
    
    
    if len(arr) != 0: return False

    return answer