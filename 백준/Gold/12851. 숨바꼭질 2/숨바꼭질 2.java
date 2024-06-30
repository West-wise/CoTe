import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void bfs(int start, int end) {
        Deque<PositionNode> queue = new ArrayDeque<>();
        queue.add(new PositionNode(start, 0));

        int[] visited = new int[100001];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        visited[start] = 0;

        int time = Integer.MAX_VALUE;
        int cnt = 0;

        while (!queue.isEmpty()) {
            PositionNode currentNode = queue.poll();
            int currentPos = currentNode.getPosition();
            int currentTime = currentNode.getTime();

            if (currentPos == end) {
                if (currentTime < time) {
                    time = currentTime;
                    cnt = 1;
                } else if (currentTime == time) {
                    cnt++;
                }
            }

            int[] array = {currentPos - 1, currentPos + 1, currentPos * 2};

            for (int position : array) {
                if (0 <= position && position <= 100000) {
                    if (currentTime + 1 <= visited[position]) {
                        visited[position] = currentTime + 1;
                        queue.add(new PositionNode(position, currentTime + 1));
                    }
                }
            }
        }

        System.out.println(time);
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        bfs(start, end);
    }
}

class PositionNode {
    int position;
    int time;

    PositionNode(int position, int time) {
        this.position = position;
        this.time = time;
    }

    public int getPosition() {
        return this.position;
    }

    public int getTime() {
        return this.time;
    }
}
