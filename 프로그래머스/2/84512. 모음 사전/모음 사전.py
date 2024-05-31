from itertools import product
def solution(word):
    answer = 0
    alphabet = ['A', 'E', 'I', 'O', 'U']
    
    words = []
    for length in range(1,6):
        
        combintaiton = list(product(alphabet, repeat=length))
        for comb in combintaiton:
            words.append(''.join(comb))
    words.sort()
    
    return words.index(word)+1