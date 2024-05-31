from collections import Counter


def solution(topping):
    answer = 0
    cnt1 = Counter()
    cnt2 = Counter(topping)

    for i in range(len(topping)-1):
        cnt1[topping[i]] += 1
        cnt2[topping[i]] -= 1
        if cnt2[topping[i]] == 0:
            del cnt2[topping[i]]

        if len(cnt1) == len(cnt2):
            answer += 1

    return answer