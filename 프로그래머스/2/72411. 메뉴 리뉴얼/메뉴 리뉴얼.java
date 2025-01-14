import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public void combinationJava(Map<String,Integer> combinations, StringBuilder current, char[] items, int r, int start){
        if(current.length() == r){
            String menu = current.toString();
            combinations.put(menu, combinations.getOrDefault(menu,0)+1);
            return;
        }
        for(int i = start; i<items.length; i++){
            current.append(items[i]);
            combinationJava(combinations, current, items, r, i+1);
            current.deleteCharAt(current.length()-1);
        }
    }
    public String[] solution(String[] orders, int[] course) {

        // 탐색속도 증가를 위해 배열을 Set으로 변환
        Set<Integer> courseSet = Arrays.stream(course).boxed().collect(Collectors.toSet());

        // 조합 map 생성
        HashMap<String, Integer> map = new HashMap<>();
        for(String menu : orders){
            char[] items = menu.toCharArray();
            Arrays.sort(items);
            for(int cnt : courseSet){
                combinationJava(map,new StringBuilder(),items,cnt,0);
            }
        }
        // 각 메뉴길이별 가장 많은 횟수 선택
        HashMap<Integer,Integer> maxCnt = new HashMap<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int length = entry.getKey().length();
            if(courseSet.contains(length)){
                maxCnt.put(length,Math.max(maxCnt.getOrDefault(length,0),entry.getValue()));
            }
        }

        HashMap<String,Integer> tmp = new HashMap<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            int menuLength = entry.getKey().length();
            if(courseSet.contains(menuLength) &&
                    maxCnt.get(menuLength).equals(entry.getValue()) &&
                    maxCnt.get(menuLength)>=2){
                tmp.put(entry.getKey(), entry.getValue());
            }
        }

        ArrayList<String> answer = new ArrayList<>(tmp.keySet());

        return answer.stream().sorted().collect(Collectors.toList()).toArray(new String[0]);
    }
}