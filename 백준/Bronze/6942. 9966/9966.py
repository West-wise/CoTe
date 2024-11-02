import sys

input = sys.stdin.buffer.readline
single_digit_set = {"1", "8", "0"}
double_digit_set = {"11", "69", "88", "96", "00"}

def check_five_digits(num):
    start, end = num[0], num[-1]
    middle = num[1:4]
    return start + end in double_digit_set and check_three_digits(middle)

def check_four_digits(num):
    block1, block2 = num[:2], num[2:]
    start, end = num[0], num[-1]
    middle = num[1:3]

    return (block1 == block2 and block1 in double_digit_set) or \
           (start + end in double_digit_set and middle in double_digit_set)

def check_three_digits(num):
    start, end = num[0], num[-1]
    middle = num[1]
    return start + end in double_digit_set and middle in single_digit_set

def check_two_digits(num):
    return num in double_digit_set

def main():
    esi = int(input().strip())
    edi = int(input().strip())
    
    if esi > edi:
        print("잘못된 범위입니다. 시작 값은 종료 값보다 작아야 합니다.")
        return

    count = 0

    for num in range(esi, edi + 1):
        str_num = str(num)
        num_len = len(str_num)
        
        if num_len == 1 and str_num in single_digit_set:
            count += 1
        elif num_len == 2 and check_two_digits(str_num):
            count += 1
        elif num_len == 3 and check_three_digits(str_num):
            count += 1
        elif num_len == 4 and check_four_digits(str_num):
            count += 1
        elif num_len == 5 and check_five_digits(str_num):
            count += 1

    print(count)

if __name__ == "__main__":
    main()
