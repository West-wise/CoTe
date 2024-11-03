import sys

input = sys.stdin.readline



# b^(-1) = B^(MOD-2)(mod MOD)
# b^(MOD-2) = b^(-1)(mod MOD)
# P = MOD
def modular_inverse(b, P):
    return pow(b, P - 2, P)


def main():
    MOD = 1000000007
    M = int(input())
    result = 0
    for i in range(M):
        # n : N면체 주사위
        # s : N면체 주사위의 모든 면의 합
        n,s = map(int,input().split())
        iv = modular_inverse(n,MOD)
        result = (result + (s * iv) % MOD) % MOD
    print(result)

if __name__ == "__main__":
    main()