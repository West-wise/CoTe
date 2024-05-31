from collections import defaultdict


def calculate_cost(fees, time):
    default_time, default_cost, unit_time, unit_cost = fees

    if time <= default_time:
        return default_cost
    else:
        return default_cost + ((time - default_time - 1) // unit_time + 1) * unit_cost


def solution(fees, records):
    answer = []

    car_in = {}
    accumulated_time = defaultdict(int)
    for record in records:
        time, car_num, io = record.split()
        time = int(time[:2]) * 60 + int(time[3:])
        if io == "IN":
            car_in[car_num] = time
        else:
            in_time = car_in.pop(car_num)
            accumulated_time[car_num] += time - in_time

    # 남은 차량에 대한 계산
    for car_num, in_time in car_in.items():
        accumulated_time[car_num] += 1439 - in_time  # 23:59를 분으로 변환한 값
    accumulated_time = dict(sorted(accumulated_time.items()))

    # 주차 요금 계산
    for time in accumulated_time.values():
        answer.append(calculate_cost(fees, time))

    return answer