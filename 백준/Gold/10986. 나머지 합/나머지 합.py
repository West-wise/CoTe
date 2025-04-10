import sys
input = sys.stdin.readline

N, M = map(int, input().split())
array = list(map(int, input().split()))

prefix_sum = 0
remainder_count = [0] * M  # 나머지 0 ~ M-1 까지
remainder_count[0] = 1  # 누적합이 0인 경우 (자기 자신부터 시작)

result = 0

for num in array:
    prefix_sum += num
    remainder = prefix_sum % M

    # null-check
    if remainder < 0:
        remainder += M

    result += remainder_count[remainder]
    remainder_count[remainder] += 1

print(result)
