def split_part(file):
    head = ""
    number = ""
    tail = ""
    for i in range(len(file)):
        if file[i].isdigit():
            head = file[:i]
            for j in range(i, len(file)):
                if not file[j].isdigit():
                    number = file[i:j]
                    tail = file[j:]
                    break
            else:
                number = file[i:]
            break

    return head, number, tail


def solution(files):
    answer = []
    file_dict = {}
    for i in files:
        head, number, tail = split_part(i)
        file_dict[i] = (head, number, tail)

    sorted_files = sorted(
        file_dict.items(), key=lambda x: (x[1][0].lower(), int(x[1][1]))
    )

    for i in sorted_files:
        answer.append(i[0])
    return answer
