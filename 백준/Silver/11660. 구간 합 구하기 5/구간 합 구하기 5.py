import sys
input = sys.stdin.readline


def func(sum_arr, range_arr):
    start = (range_arr[0]-1, range_arr[1]-1)
    end = (range_arr[2]-1, range_arr[3]-1)
    diff = (end[0]-start[0]+1, end[1]-start[1]+1)
    
    res = sum_arr[end[0]][end[1]] - sum_arr[end[0]][end[1]-diff[1]] - sum_arr[end[0]-diff[0]][end[1]] + sum_arr[start[0]-1][start[1]-1]
    print(res)
    
def main():
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    arr2 = [list(map(int, input().split())) for _ in range(M)]
    
    
    tmp_arr = [[0] * (N+1) for _ in range(N+1)]
    for i in range(N):
        for k in range(N):
            tmp_arr[i][k] = tmp_arr[i][k-1] + tmp_arr[i-1][k] - tmp_arr[i-1][k-1] + arr[i][k]
            
    for i in range(M):
        func(tmp_arr,arr2[i])

if __name__ == "__main__":
    main()