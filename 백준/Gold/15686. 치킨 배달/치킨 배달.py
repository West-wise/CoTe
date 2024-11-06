import sys
from itertools import combinations


input = sys.stdin.readline

def house_chicken(chicken, house):
    result = []
    for r1, c1 in house:
        min_distance = min(map(lambda chicken_pos: abs(r1 - chicken_pos[0]) + abs(c1 - chicken_pos[1]), chicken))
        result.append(min_distance)

    return sum(result)
# def house_chicken(chicken, house):
#     result = []
#     for r1, c1 in house:
#         tmp = []
#         for r2, c2 in chicken:
#             tmp.append(abs(r1-r2) + abs(c1-c2))
#         result.append(min(tmp))
#
#     return sum(result)


# 백 트래킹으로 지울 치킨집을 선택 or 그냥 브루트 포스로 진행..
def remove_chicken(chicken, house):
    pass

if __name__ == "__main__":
    N,M = map(int,input().split())

    city = [list(map(int, input().split())) for _ in range(N)]

    chicken = []
    house = []
    for i in range(N):
        for k in range(N):
            if city[i][k] == 2:
                chicken.append((i,k))
            if city[i][k] == 1:
                house.append((i,k))

    combi = list(combinations(chicken,M))
    result = []
    for combi_chicken in combi:
        result.append(house_chicken(combi_chicken,house))
    print(min(result))