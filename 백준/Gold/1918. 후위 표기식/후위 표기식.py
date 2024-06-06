def infix_to_postfix(infix_expression):
    operators = {'+': 1, '-': 1, '*': 2, '/': 2}
    stack = []
    postfix_expression = []
    
    for char in infix_expression:
        if char.isalpha():
            postfix_expression.append(char)
        elif char == '(':
            stack.append(char)
        elif char == ')':
            while stack and stack[-1] != '(':
                postfix_expression.append(stack.pop())
            stack.pop()  # pop '('
        elif char in operators:
            while stack and operators.get(stack[-1], 0) >= operators[char]:
                postfix_expression.append(stack.pop())
            stack.append(char)

    while stack:
        postfix_expression.append(stack.pop())

    return ''.join(postfix_expression)

infix_expression = input()
postfix_expression = infix_to_postfix(infix_expression)
print(postfix_expression)
