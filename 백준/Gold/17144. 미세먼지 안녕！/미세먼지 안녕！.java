import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int R = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);
        int T = Integer.parseInt(line[2]);
        int[] air_cleaner = new int[2];
        map = new int[R][C];
        for(int i = 0; i<R; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int k = 0; k<C; k++){
                if(input[k] == -1) {
                    air_cleaner[0] = i-1;
                    air_cleaner[1] = i;
                }
                map[i][k] = input[k];
            }
        }
        for(int i = 0; i<T; i++){
            spread_dust();
            cleaning(air_cleaner);
        }
        int answer = 0;
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(map[i][j] >0)answer+=map[i][j];
            }
        }
        System.out.println(answer);
    }
    private static void spread_dust(){
        int high = map.length;
        int width = map[0].length;
        int[][] temp = new int[high][width];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i = 0; i<high; i++){
            for(int j=0; j<width; j++){
                if(map[i][j] >= 5){
                    int spreadAmount = map[i][j]/5;
                    if (spreadAmount == 0) continue;
                    int cnt = 0;
                    for(int[] dir : directions){
                        int ny = i + dir[0], nx = j + dir[1];
                        if(ny >=0 && ny < high && nx >= 0 && nx < width && map[ny][nx] != -1){
                            temp[ny][nx] += spreadAmount;
                            cnt++;
                        }
                    }
                    temp[i][j] -= (spreadAmount * cnt);
                }
            }
        }
        for(int i = 0; i<high; i++){
            for(int j = 0; j<width; j++){
                if (map[i][j] != -1) {
                    map[i][j] += temp[i][j];
                }
            }
        }
    }
    private static void cleaning(int[] air_cleaner){
        int head = air_cleaner[0], tail = air_cleaner[1];
        int high = map.length, width = map[0].length;
        // 시계 방향
        for(int i = head-1; i>0; i--) map[i][0] = map[i-1][0];
        for(int i = 0; i<width-1; i++) map[0][i] = map[0][i+1];
        for(int i = 0; i<head; i++) map[i][width-1] = map[i+1][width-1];
        for(int i = width-1; i>1; i--) map[head][i] = map[head][i-1];
        map[head][1] = 0;
        for (int i = tail + 1; i < high - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < width - 1; i++) map[high - 1][i] = map[high - 1][i + 1];
        for (int i = high - 1; i > tail; i--) map[i][width - 1] = map[i - 1][width - 1];
        for (int i = width - 1; i > 1; i--) map[tail][i] = map[tail][i - 1];
        map[tail][1] = 0;
    }
}
