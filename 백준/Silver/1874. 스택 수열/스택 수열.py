import sys

def check(arr):
    
    
    return True


n = int(sys.stdin.readline())

target = []
arr = []
res = []
for i in range(n):
    target.append(int(sys.stdin.readline()))

    
for i in range(1, n+1):
    
    arr.append(i)
    res.append('+')

    while arr and arr[-1] == target[0]:
        arr.pop()
        target.pop(0)
        res.append('-')

if len(arr) != 0:
    print('NO')
else:
    for i in res:
        print(i)