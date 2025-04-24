from queue import Queue
card = Queue()
N = int(input())
for i in range(1,N+1):
    card.put(i)

for i in range(N-1):
    card.get()
    card.put(card.get())
    
print(card.get())