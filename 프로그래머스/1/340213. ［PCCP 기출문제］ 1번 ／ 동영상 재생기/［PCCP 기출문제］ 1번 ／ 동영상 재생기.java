class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = pos;
        if (toSeconds(op_start) < toSeconds(answer) && toSeconds(answer) < toSeconds(op_end)){
            answer = op_end;
        }
        for(String cmd : commands){

            if (cmd.equals("next")){
                if (toSeconds(video_len) < toSeconds(answer) + 10){
                    answer = video_len;
                } else{
                    answer = addOrSubtractTime(answer,10);
                }
            } else if (cmd.equals("prev")) {
                // prev했을 때 고려해야할 사항
                // 1. 10초 전이 00:00 보다 뒤에있는가
                if(toSeconds(answer) - 10 <0){
                    answer = "00:00";
                } else{
                    answer =addOrSubtractTime(answer,-10);
                }
            }
            if (toSeconds(op_start) <= toSeconds(answer) && toSeconds(answer) <= toSeconds(op_end)){
                answer = op_end;
            }
        }

        return answer;
    }
    // 시간 계산: 초 단위로 더하거나 빼는 메서드
    public String addOrSubtractTime(String pos, int offset) {
        int totalSeconds = toSeconds(pos) + offset; // 초 단위 계산
        if (totalSeconds < 0) totalSeconds = 0; // 음수 시간 방지
        return toTimeFormat(totalSeconds);
    }

    // "MM:SS" 형식으로 변환
    public String toTimeFormat(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public static int toSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds; // 총 초로 변환
    }
}