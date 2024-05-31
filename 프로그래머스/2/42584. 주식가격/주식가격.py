def solution(prices):
    answer = []
    arr = [0] * len(prices)
    #주어진 길이만큼의 배열을 0으로 초기화

    before = 0

    for i in range(len(prices)):
        cnt = 0
        for k in range(i+1,len(prices)):
            if prices[i]>prices[k]:
                cnt +=1
                break
            cnt+=1
        arr[i] = cnt

    return arr