A,B,C = map(int, input().split())

# 분할정복을 이용한 거듭제곱
def power(a,b):
    if b == 1:
        return a % C
    else:
        temp = power(a, b//2)
        if b % 2 == 0:
            return temp * temp % C
        else:
            return temp * temp * a % C
        
print(power(A,B))