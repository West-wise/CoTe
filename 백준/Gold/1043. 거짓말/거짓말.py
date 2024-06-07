import sys
from collections import deque

input = sys.stdin.readline

if __name__ == "__main__":
    truth = set()

    N, M = map(int, input().split())
    answer = 0
    tmp = list(map(int, input().split()))
    truth.update(tmp[1:])

    parties = []
    for _ in range(M):
        parties.append(list(map(int, input().split()))[1:])

    # 진실을 아는 사람들의 정보를 업데이트하기 위한 큐
    queue = deque(truth)

    while queue:
        person = queue.popleft()
        for party in parties:
            if person in party:
                for p in party:
                    if p not in truth:
                        truth.add(p)
                        queue.append(p)

    for party in parties:
        if all(person not in truth for person in party):
            answer += 1

    print(answer)
