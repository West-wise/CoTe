def solve(a, b):
    # Check if a - b is divisible by 3
    if (a - b) % 3 != 0:
        print(-1)
        return
    
    k = (a - b) // 3  # This is x - z

    # Start with x = max(0, k) because x >= z + k
    for x in range(max(0, k), a // 3 + 1):
        y = a - 3 * x
        z = x - k
        if z >= 0 and y >= 0:
            print(x, y, z)
            return
    
    print(-1)

# Reading input values
a = int(input().strip())
b = int(input().strip())

# Solve the problem
solve(a, b)
