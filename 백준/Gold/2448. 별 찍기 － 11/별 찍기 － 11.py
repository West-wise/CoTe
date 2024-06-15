def tree(base):
    k = len(base)
    tmp = []
    for line in base:
        tmp.append(" " * k + line + " " * k)
    for line in base:
        tmp.append(line + " " + line)
    return tmp


if __name__ == "__main__":
    n = int(input())
    base = ["  *  ", " * * ", "*****"]
    while len(base) != n:
        base = tree(base)

    for i in base:
        print(i)
