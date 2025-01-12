import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public ArrayList<Integer> pickTwo(HashMap<Integer, Integer> map, int size) {
        // value(재생 횟수) 내림차순, value가 같다면 key(고유번호) 오름차순 정렬
        List<Integer> list = map.entrySet().stream()
                .sorted((e1, e2) -> {
                    if (!e1.getValue().equals(e2.getValue())) {
                        return e2.getValue() - e1.getValue(); // 재생 횟수 내림차순
                    }
                    return e1.getKey() - e2.getKey(); // 고유번호 오름차순
                })
                .map(Map.Entry::getKey) // 고유번호 가져오기
                .collect(Collectors.toList());

        // 상위 size만큼 선택
        return new ArrayList<>(list.subList(0, Math.min(size, list.size())));
    }

    public ArrayList<String> ranking(HashMap<String, Integer> map, int size) {
        // value(총 재생 횟수) 내림차순 정렬
        List<String> list = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // size만큼 자르기
        return new ArrayList<>(list.subList(0, Math.min(size, list.size())));
    }

    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        HashMap<String, Integer> listenSum = new HashMap<>();

        // 데이터를 장르별로 분류 및 재생 횟수 합산
        for (int i = 0; i < genres.length; i++) {
            HashMap<Integer, Integer> temp = map.getOrDefault(genres[i], new HashMap<>());
            // key: 고유번호, value: 재생 횟수
            temp.put(i, plays[i]);
            map.put(genres[i], temp);

            // 장르별 총 재생 횟수 합산
            listenSum.put(genres[i], listenSum.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르별 총합이 큰 순서대로 정렬
        List<String> genreRank = ranking(listenSum, listenSum.size());

        // 각 장르에서 상위 2곡 선택
        for (String genre : genreRank) {
            ArrayList<Integer> tmp = pickTwo(map.get(genre), 2);
            answer.addAll(tmp);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
