import java.util.*;

class Solution {
    static String[][] val_matrix = new String[51][51]; // value값을 저장하는 용도
    static String[][] idx_matrix = new String[51][51]; // 인덱스를 저장하는 용도

    private String convertCordinate (int[] idx){
        return idx[0] +","+idx[1];
    }
    private String find(int[] cordi){
        String idx = convertCordinate(cordi);
        String parent = idx_matrix[cordi[0]][cordi[1]];
        if(idx.equals(parent)) return idx;
        String[] parts = parent.split(",");
        String root = find(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
        idx_matrix[cordi[0]][cordi[1]] = root;
        return root;
    }

    private void union(int[] coor1, int[] coor2){
        String rootA = find(coor1), rootB = find(coor2);
        if(rootA.equals(rootB)) return;
        String[] parts1 = rootA.split(","), parts2 = rootB.split(",");
        int rootAR = Integer.parseInt(parts1[0]), rootAC = Integer.parseInt(parts1[1]);
        int rootBR = Integer.parseInt(parts2[0]), rootBC = Integer.parseInt(parts2[1]);

        String rootVal = val_matrix[rootAR][rootAC];
        if(rootVal == null) rootVal = val_matrix[rootBR][rootBC];

        idx_matrix[rootBR][rootBC] = rootA;
        val_matrix[rootAR][rootAC] = rootVal;
        val_matrix[rootBR][rootBC] = null;
    }
    private void unmerged(int r, int c){
        String targetRoot = find(new int[]{r,c});
        String[] parts = targetRoot.split(",");
        int tr = Integer.parseInt(parts[0]), tc = Integer.parseInt(parts[1]);
        String original = val_matrix[tr][tc];
        List<int[]> reset = new ArrayList<>();
        for(int i = 1; i<=50; i++){
            for(int k=1; k<=50; k++){
                if(find(new int[]{i,k}).equals(targetRoot)){
                    reset.add(new int[]{i,k});
                }
            }
        }
        for(int[] cell : reset){
            int ir = cell[0], ic = cell[1];
            idx_matrix[ir][ic] = convertCordinate(cell);
            val_matrix[ir][ic] = null;
        }
        val_matrix[r][c] = original;
    }
    private void init(){
        for(int i = 0; i<=50; i++){
            for(int k = 0; k<=50; k++){
                idx_matrix[i][k] = convertCordinate(new int[]{i,k});
            }
        }
    }
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        String[] parts;
        init();
        for(String command : commands){
            String[] input = command.split(" ");
            int[] val1, val2;
            switch(input[0]){
                case "UPDATE":
                    if(input.length == 4){ // UPDATE r c value
                        val1 = new int[]{Integer.parseInt(input[1]), Integer.parseInt(input[2])};
                        parts = find(val1).split(",");
                        int rootA = Integer.parseInt(parts[0]);
                        int rootB = Integer.parseInt(parts[1]);
                        val_matrix[rootA][rootB] = input[3];
                    } else { // UPDATE value1 value2, value1값을 가진 모든 셀을 value2로 업데이트
                        for(int i = 1; i<=50; i++){
                            for(int k = 1; k<=50; k++){
                                if(convertCordinate(new int[]{i,k}).equals(idx_matrix[i][k])){
                                    if(input[1].equals(val_matrix[i][k])) val_matrix[i][k] = input[2];
                                }
                            }
                        }
                    }
                    break;
                case "MERGE": // MERGE r1 c1 r2 c2
                    val1 = new int[]{Integer.parseInt(input[1]), Integer.parseInt(input[2])};
                    val2 = new int[]{Integer.parseInt(input[3]), Integer.parseInt(input[4])};
                    union(val1, val2);
                    break;
                case "UNMERGE": // UNMERGE r c
                    int r = Integer.parseInt(input[1]);
                    int c = Integer.parseInt(input[2]);
                    unmerged(r,c);
                    break;
                case "PRINT": // PRINT r c
                    val1 = new int[]{Integer.parseInt(input[1]), Integer.parseInt(input[2])};
                    parts = find(val1).split(",");
                    String value = val_matrix[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])];
                    answer.add( value == null ? "EMPTY" : value);
                    break;
            }
        }
        return answer.toArray(new String[0]);
    }
}