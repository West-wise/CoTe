import java.util.*;

class Solution {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] ratio = new double[N];
        // stage, 실패율
        Map<Integer,Double> stageMap = new HashMap<>();

        //분모를 일단 입력
        for(int i=1; i<=N; i++){
            int numer = 0;
            int denom = 0;
            for(int stage : stages){
                if(i<=stage) { // 스테이지에 도달한 사람
                    denom++;
                }
                if(i==stage){ // 도달했지만 클리어하지 못한 사람
                    numer++;
                }
            }
            stageMap.put(i, denom == 0 ? 0 : (double) numer / denom);
        }

        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(stageMap.entrySet());
        entryList.sort((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                // 보니까 이게 지금 파라미터를 기준으로 하는 듯 하다..
                // e2,e1했을때는 [4, 3, 2, 1, 5]
                // e1, e2했을 때는 [3, 4, 2, 1, 5] 이렇게 나오는걸보니 파라미터도 신경써야할듯하네..
                return Integer.compare(e1.getKey(), e2.getKey()); // 스테이지 번호 내림차순
            } else {
                return Double.compare(e2.getValue(), e1.getValue()); // 실패율 내림차순
            }
        });
        for(int i=0; i<N;i++){
            answer[i] = entryList.get(i).getKey();
        }
        return entryList.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}