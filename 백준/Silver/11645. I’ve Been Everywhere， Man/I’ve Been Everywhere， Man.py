import sys

input = sys.stdin.readline

def main():
    T = int(input())
    for i in range(T):
        n = int(input())
        contry_set = set()
        for k in range(n):
            contry_set.add(input())
        print(len(contry_set))


if __name__ == "__main__":
    main()