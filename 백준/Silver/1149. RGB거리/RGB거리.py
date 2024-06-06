import sys

input = sys.stdin.readline

N = int(input())
cost = [list(map(int, input().split())) for _ in range(N)]

# 연속하는 3개 집이 같은 색이 아니게 칠하는 비용의 최솟값
def func(n,cost):
    dp = [[0]*3 for _ in range(n)]
    dp[0][0] = cost[0][0]
    dp[0][1] = cost[0][1]
    dp[0][2] = cost[0][2]
    
    
    for i in range(1,n):
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + cost[i][0]
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + cost[i][1]
        dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + cost[i][2]
    
    return min(dp[n-1])
print(func(N, cost))