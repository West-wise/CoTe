import sys
from collections import deque

input = sys.stdin.readline


def BFS(parties, truth):

    q = deque(truth)

    while q:
        person = q.popleft()
        for party in parties:
            if person in party:
                for p in party:
                    if p not in truth:
                        q.append(p)
                        truth.add(p)


if __name__ == "__main__":

    truth = set()

    N, M = map(int, input().split())
    answer = 0  # 거짓말을 말할 수 있는 파티 수,
    tmp = list(map(int, input().split()))
    truth.update(tmp[1:])

    parties = []
    for _ in range(M):
        parties.append(list(map(int, input().split()))[1:])

    BFS(parties, truth)

    for party in parties:
        if all(person not in truth for person in party):
            answer += 1

    print(answer)
