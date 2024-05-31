import heapq

def solution(scoville, K):
    answer = 0

    heap = scoville
    heapq.heapify(heap)
    while heap[0]<K:
        if len(heap)<2:
            return -1
        new = heapq.heappop(heap) + heapq.heappop(heap)*2
        heapq.heappush(heap,new)
        answer+=1

    return answer