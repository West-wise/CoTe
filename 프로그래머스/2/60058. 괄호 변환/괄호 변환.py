def check_correct(u):
    if u.startswith(")"):
        return False
    stack = []
    for i in u:
        if i == "(":
            stack.append(i)
        else:  # ")"
            if stack:
                stack.pop()
    if not stack:
        return True
    return False


def div_str(p):
    u, v = "", ""
    for i in p:
        if u.count("(") == u.count(")") and len(u) > 0:
            break
        u += i
    return u, p[len(u) :]

def upside_down(u):
    res = "".join(")" if i == "(" else "(" for i in u)
    return res


def solution(p):
    if not p:
        return ""
    if check_correct(p):
        return p

    u, v = div_str(p)
    if check_correct(u):
        return u + solution(v)
    else:
        tmp = "(" + solution(v) + ")"
        return tmp + upside_down(u[1 : len(u) - 1])