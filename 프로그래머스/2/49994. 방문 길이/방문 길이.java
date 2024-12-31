import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;

        Set<List<Integer>> visited = new HashSet<>();
        int start_x = 5;
        int start_y = 5;

        for(char dir : dirs.toCharArray()) {
            int end_x = start_x;
            int end_y = start_y;

            switch(dir) {
                case 'U':
                    if(start_y + 1 <=10) end_y++;
                    break;
                case 'D':
                    if(start_y -1 >= 0) end_y--;
                    break;
                case 'R':
                    if(start_x + 1 <= 10) end_x++;
                    break;
                case 'L':
                    if(start_x -1 >= 0) end_x--;
                    break;
            }

            if(start_x != end_x || start_y != end_y) {
                List<Integer> path = Arrays.asList(start_x,start_y,end_x,end_y);
                List<Integer> rev_path = Arrays.asList(end_x,end_y,start_x,start_y);

                if(visited.add(path) && visited.add(rev_path)) answer++;

                start_x = end_x;
                start_y = end_y;
            }
        }
        return answer;
    }
}
