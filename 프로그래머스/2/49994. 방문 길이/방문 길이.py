# level 2
def check(dirs):
    start_x = 5
    start_y = 5
    passed = []
    new_road_length = 0
    for dir in dirs:
        before = [start_x, start_y]
        if dir == 'U':
            if start_y + 1 > 10:
                continue
            else:
                tuple = (before, [start_x, start_y+1])
                if tuple in passed or tuple[::-1] in passed:
                    start_y += 1
                    continue
                else:
                    start_y += 1
                    passed.append(tuple)
                    new_road_length += 1
        elif dir == 'D':
            if start_y - 1 < 0 :
                continue
            else:
                tuple = (before, [start_x, start_y-1])
                if tuple in passed or tuple[::-1] in passed:
                    start_y -= 1
                    continue
                else:
                    start_y -= 1
                    passed.append(tuple)
                    new_road_length += 1
        elif dir == 'L':
            if start_x - 1 < 0:
                continue
            else:
                tuple = (before, [start_x-1, start_y])
                if tuple in passed or tuple[::-1] in passed:
                    start_x -= 1
                    continue
                else:
                    start_x -= 1
                    passed.append(tuple)
                    new_road_length += 1
        elif dir == 'R':
            if start_x + 1 > 10:
                continue
            else:
                tuple = (before, [start_x+1, start_y])
                if tuple in passed or tuple[::-1] in passed:
                    start_x += 1
                    continue
                else:
                    start_x += 1
                    passed.append(tuple)
                    new_road_length += 1
    print(passed)
    return new_road_length

def solution(dirs):
    
    return check(dirs)