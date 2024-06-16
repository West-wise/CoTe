def count_unique_sequences(password1, password2):
    count = 1
    for i in range(4):
        if password1[i] == password2[i]:
            count *= 1
        else:
            count *= 2
    return count

if __name__ == "__main__":
    password1 = input().strip()
    password2 = input().strip()
    result = count_unique_sequences(password1, password2)
    print(result)
