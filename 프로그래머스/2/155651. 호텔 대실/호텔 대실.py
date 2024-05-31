import heapq
from datetime import datetime, timedelta

def time_diff(time1, time2):
    fmt = "%H:%M"
    new_client_enter_time = datetime.strptime(time1, fmt)
    before_client_exit_time = datetime.strptime(time2, fmt) + timedelta(minutes=10)
    return new_client_enter_time >=before_client_exit_time

def solution(book_time):
    times = sorted(book_time)
    rooms = []
    
    for start, end in times:
        if rooms and time_diff(start, rooms[0]):
            heapq.heapreplace(rooms, end)
        else:
            heapq.heappush(rooms, end)
    return len(rooms)