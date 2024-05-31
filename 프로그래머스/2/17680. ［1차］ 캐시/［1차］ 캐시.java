import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>(cacheSize);

        if (cacheSize == 0) { // 캐시 크기가 0인 경우 모든 도시가 cache miss
            return cities.length * 5;
        }

        for (String city : cities) {
            String upperCity = city.toUpperCase();

            if (cache.contains(upperCity)) { // cache hit
                cache.remove(upperCity);
                cache.add(upperCity);
                answer++;
            } else { // cache miss
                if (cache.size() == cacheSize) { // cache가 꽉 찬 경우 가장 오래된 도시를 제거
                    cache.remove(0);
                }
                cache.add(upperCity);
                answer += 5;
            }
        }

        return answer;
    }
}
