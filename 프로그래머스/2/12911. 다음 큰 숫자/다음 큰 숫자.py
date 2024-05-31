def bit_count(n):
    return bin(n).count("1")

def solution(n):
    answer = n+1
    nbit = bit_count(n)
    while True:
        if nbit == bit_count(answer):
            break;
        else:
            answer+=1
    return answer