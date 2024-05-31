import re
from itertools import permutations


def solution(expression):
    answer = []
    pattern = r"[\+\-\*]"
    operators = set(re.findall(pattern, expression))
    op_permutations = permutations(operators)
    for each_ops in op_permutations:
        num_in_exp = re.split(pattern, expression)
        op_in_exp = re.findall(pattern, expression)
        for op in each_ops:
            while op in op_in_exp:
                idx = op_in_exp.index(op)
                num_in_exp[idx] = str(eval(num_in_exp[idx] + op + num_in_exp[idx + 1]))
                num_in_exp.pop(idx + 1)
                op_in_exp.pop(idx)
        answer.append(abs(int(num_in_exp[0])))
    return max(answer)