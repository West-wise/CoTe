from sys import stdin

input = stdin.readline


def solution(string, bomb):

    stack = []
    bomb_last = bomb[-1]
    blen = len(bomb)
    for char in string:
        stack.append(char)
        if len(stack) >= len(bomb) and stack[-1] == bomb_last:
            if "".join(stack[-blen:]) == bomb:
                del stack[-blen:]
    return "".join(stack) if stack else "FRULA"


if __name__ == "__main__":
    string = input().rstrip()
    bomb = input().rstrip()

    print(solution(string, bomb))
