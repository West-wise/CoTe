import sys
from itertools import combinations

input = sys.stdin.readline

def house_chicken(chicken, house):
    total_distance = 0
    for r1, c1 in house:
        min_distance = float('inf')
        for r2, c2 in chicken:
            distance = abs(r1 - r2) + abs(c1 - c2)
            if distance < min_distance:
                min_distance = distance
        total_distance += min_distance
    return total_distance

if __name__ == "__main__":
    N, M = map(int, input().split())
    city = [list(map(int, input().split())) for _ in range(N)]

    chicken = []
    house = []
    for i in range(N):
        for k in range(N):
            if city[i][k] == 2:
                chicken.append((i, k))
            elif city[i][k] == 1:
                house.append((i, k))

    # 가능한 치킨집 조합 중 최적의 결과만을 계산
    min_total_distance = float('inf')
    for combi_chicken in combinations(chicken, M):
        total_distance = house_chicken(combi_chicken, house)
        if total_distance < min_total_distance:
            min_total_distance = total_distance

    print(min_total_distance)
