import sys
input = sys.stdin.readline
MOD = 1000000007
M = int(input())
result = 0
for i in range(M):
    n,s = map(int,input().split())
    result = (result + (s * pow(n,MOD-2,MOD)) % MOD) % MOD
print(result)