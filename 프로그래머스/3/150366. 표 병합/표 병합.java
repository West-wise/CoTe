import java.util.*;

class Solution {
    // 1. 상태 관리를 위한 변수 (static 제거: 테스트 케이스 간 간섭 방지)
    // parent: 각 셀의 부모 좌표 문자열 저장 ("r,c")
    private String[][] parent = new String[51][51];
    // value: 각 그룹의 Root 셀에만 실제 값을 저장 (나머지는 null)
    private String[][] value = new String[51][51];

    // 좌표 변환 헬퍼 (int[] -> String)
    private String convertCordinate(int r, int c) {
        return r + "," + c;
    }

    // 2. Find 연산 (경로 압축 Path Compression 적용)
    private String find(int r, int c) {
        String idx = convertCordinate(r, c);
        
        // 방어 코드: 초기화되지 않은 경우
        if (parent[r][c] == null) {
            parent[r][c] = idx;
            return idx;
        }

        if (idx.equals(parent[r][c])) {
            return idx;
        }

        String[] parts = parent[r][c].split(",");
        int pr = Integer.parseInt(parts[0]);
        int pc = Integer.parseInt(parts[1]);
        
        // 재귀를 통한 Root 찾기 및 경로 압축
        String root = find(pr, pc);
        parent[r][c] = root; 
        return root;
    }

    // 초기화 메서드
    private void init() {
        for (int i = 1; i <= 50; i++) {
            for (int k = 1; k <= 50; k++) {
                parent[i][k] = convertCordinate(i, k);
                value[i][k] = null;
            }
        }
    }

    public String[] solution(String[] commands) {
        // 방어 코드
        if (commands == null) return new String[0];

        List<String> answer = new ArrayList<>();
        init(); // 매 실행마다 초기화 필수

        for (String command : commands) {
            if (command == null || command.isEmpty()) continue;
            String[] input = command.split(" ");
            
            String cmd = input[0];

            switch (cmd) {
                case "UPDATE":
                    // Case 1: UPDATE r c value
                    if (input.length == 4) { 
                        int r = Integer.parseInt(input[1]);
                        int c = Integer.parseInt(input[2]);
                        String newValue = input[3];

                        // 해당 셀의 Root를 찾아 값 갱신
                        String root = find(r, c);
                        String[] parts = root.split(",");
                        int rootR = Integer.parseInt(parts[0]);
                        int rootC = Integer.parseInt(parts[1]);
                        
                        value[rootR][rootC] = newValue;
                    } 
                    // Case 2: UPDATE value1 value2
                    else { 
                        String val1 = input[1];
                        String val2 = input[2];

                        // 전체 셀을 순회하며 Root인 셀의 값만 변경
                        for (int i = 1; i <= 50; i++) {
                            for (int k = 1; k <= 50; k++) {
                                String cur = convertCordinate(i, k);
                                // 자신이 Root이고 값이 val1과 같다면 변경
                                if (cur.equals(parent[i][k])) {
                                    if (val1.equals(value[i][k])) {
                                        value[i][k] = val2;
                                    }
                                }
                            }
                        }
                    }
                    break;

                case "MERGE":
                    int r1 = Integer.parseInt(input[1]);
                    int c1 = Integer.parseInt(input[2]);
                    int r2 = Integer.parseInt(input[3]);
                    int c2 = Integer.parseInt(input[4]);

                    String root1Str = find(r1, c1);
                    String root2Str = find(r2, c2);

                    // 이미 같은 그룹이면 무시
                    if (root1Str.equals(root2Str)) break;

                    String[] p1 = root1Str.split(",");
                    int root1R = Integer.parseInt(p1[0]);
                    int root1C = Integer.parseInt(p1[1]);

                    String[] p2 = root2Str.split(",");
                    int root2R = Integer.parseInt(p2[0]);
                    int root2C = Integer.parseInt(p2[1]);

                    // 값 병합 우선순위 로직: (r1, c1) 우선, 없으면 (r2, c2)
                    String rootVal = value[root1R][root1C];
                    if (rootVal == null) {
                        rootVal = value[root2R][root2C];
                    }

                    // 구조 병합: Root2를 Root1에 붙임
                    parent[root2R][root2C] = root1Str;
                    
                    // 값 정리: Root1에 최종 값 설정, Root2의 값은 제거
                    value[root1R][root1C] = rootVal;
                    value[root2R][root2C] = null;
                    break;

                case "UNMERGE":
                    int r = Integer.parseInt(input[1]);
                    int c = Integer.parseInt(input[2]);

                    String targetRoot = find(r, c);
                    // 해제 전 원래 값 백업 (Root에서 가져옴)
                    String[] rootParts = targetRoot.split(",");
                    int tr = Integer.parseInt(rootParts[0]);
                    int tc = Integer.parseInt(rootParts[1]);
                    String originVal = value[tr][tc];

                    // [중요] 해제 대상 셀들을 먼저 수집 (루프 돌면서 바로 끊으면 find 결과가 달라짐)
                    List<int[]> toReset = new ArrayList<>();
                    for (int i = 1; i <= 50; i++) {
                        for (int k = 1; k <= 50; k++) {
                            if (find(i, k).equals(targetRoot)) {
                                toReset.add(new int[]{i, k});
                            }
                        }
                    }

                    // 수집된 셀들 초기화
                    for (int[] cell : toReset) {
                        int ir = cell[0];
                        int ic = cell[1];
                        parent[ir][ic] = convertCordinate(ir, ic); // 부모를 자기 자신으로 리셋
                        value[ir][ic] = null; // 값 비우기
                    }

                    // UNMERGE 대상 셀(r, c)에만 원래 값 복원
                    value[r][c] = originVal;
                    break;

                case "PRINT":
                    int pr = Integer.parseInt(input[1]);
                    int pc = Integer.parseInt(input[2]);
                    
                    String rootP = find(pr, pc);
                    String[] pp = rootP.split(",");
                    int rootPR = Integer.parseInt(pp[0]);
                    int rootPC = Integer.parseInt(pp[1]);

                    String val = value[rootPR][rootPC];
                    answer.add(val == null ? "EMPTY" : val);
                    break;
            }
        }
        return answer.toArray(new String[0]);
    }
}