import java.util.*;
class Solution {
    Map<Long, Long> parent = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = find(room_number[i]);
        }
        return answer;
    }
    private long find(long room) {
        if (!parent.containsKey(room)) {
            parent.put(room, room + 1);
            return room;
        }
        long next = find(parent.get(room));
        parent.put(room, next);
        return next;
    }
}