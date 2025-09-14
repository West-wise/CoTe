import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        int[] temp = new int[my_string.length()];
        int count = 0;
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (c >= '0' && c <= '9') {
                temp[count] = c - '0';
                count++;
            }
        }
        if (count == 0) {
            return new int[0];
        }
        int[] answer = Arrays.copyOf(temp, count);
        Arrays.sort(answer);

        return answer;
    }
}
