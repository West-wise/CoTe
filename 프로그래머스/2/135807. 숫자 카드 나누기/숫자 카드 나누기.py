import math
from functools import reduce

def gcd_of_array(array):
    return reduce(math.gcd, array)

def solution(arrayA, arrayB):
    gcd_a = gcd_of_array(arrayA)
    gcd_b = gcd_of_array(arrayB)

    can_divide_b = any(a % gcd_b == 0 for a in arrayA)
    can_divide_a = any(b % gcd_a == 0 for b in arrayB)

    if can_divide_b:
        gcd_b = 0
    if can_divide_a:
        gcd_a = 0

    return max(gcd_a, gcd_b)