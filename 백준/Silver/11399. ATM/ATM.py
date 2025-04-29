import sys

input = sys.stdin.readline

N = int(input())

P = list(map(int, input().split()))
dic = {}
for i in range(1,N+1):
    dic[i] = P[i-1]

dic = dict(sorted(dic.items(), key=lambda x:x[1]))
previous_time = 0
time = 0
for i in dic.values():
    previous_time += i
    time += previous_time
print(time)

