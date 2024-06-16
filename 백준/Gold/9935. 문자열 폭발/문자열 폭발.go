package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func solution(str, bomb string) string {
	stack := []rune{}
	bombLast := rune(bomb[len(bomb)-1])
	bLen := len(bomb)

	for _, char := range str {
		stack = append(stack, char)
		if len(stack) >= bLen && stack[len(stack)-1] == bombLast {
			if string(stack[len(stack)-bLen:]) == bomb {
				stack = stack[:len(stack)-bLen]
			}
		}
	}

	if len(stack) == 0 {
		return "FRULA"
	}
	return string(stack)
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	str, _ := reader.ReadString('\n')
	bomb, _ := reader.ReadString('\n')

	str = strings.TrimSpace(str)
	bomb = strings.TrimSpace(bomb)

	fmt.Println(solution(str, bomb))
}
