def split_record(record):

    res = record.split()
    if len(res) == 3:
        return res[0], res[1], res[2]
    else:
        return res[0], res[1], None


def solution(record):
    answer = []
    log = {}

    for i in record:
        action, uid, name = split_record(i)
        if action == "Enter":
            log[uid] = name
            answer.append(f"{uid}님이 들어왔습니다.")
        elif action == "Leave":
            answer.append(f"{uid}님이 나갔습니다.")
        elif action == "Change":
            log[uid] = name

    for i in range(len(answer)):
        uid = answer[i].split("님")[0]
        answer[i] = answer[i].replace(uid, log[uid])
    return answer