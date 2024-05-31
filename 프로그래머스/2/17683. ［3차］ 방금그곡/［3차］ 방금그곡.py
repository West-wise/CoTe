from collections import deque
from datetime import datetime, timedelta


def time_diff(time1, time2):
    fmt = "%H:%M"
    td = datetime.strptime(time2, fmt) - datetime.strptime(time1, fmt)
    return int(td.total_seconds() / 60)


def split_node(lylics):
    return_list = []
    num = 0
    while num < len(lylics):
        note = lylics[num]
        if num + 1 < len(lylics) and lylics[num + 1] == "#":
            note += "#"
            num += 1
        return_list.append(note)
        num += 1
    return return_list


def string_check(str1, str2):
    str1_len = len(str1)
    for i in range(len(str2) - str1_len + 1):
        if str1 == str2[i : i + str1_len]:
            return True
    return False


def solution(m, musicinfos):
    answer = ""
    ans = []
    m = split_node(m)
    for idx, music in enumerate(musicinfos):
        start_time, end_time, title, lylics = music.split(",")
        play_note = []
        lylics_note = deque(split_node(lylics))
        play_time = time_diff(start_time, end_time)
        for _ in range(play_time):
            note = lylics_note.popleft()
            play_note.append(note)
            lylics_note.append(note)
        if len(m) > len(play_note):
            continue
        if string_check(m, play_note):
            ans.append((play_time, idx, title))
    if ans:
        ans.sort(key=lambda x: (-x[0], x[1]))
        return ans[0][2]
    return "(None)"