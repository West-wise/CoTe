import java.util.*;
class Solution {
    public int Dijkstra(Map<Integer, List<int[]>> map, int k){
        Map<Integer, Integer> distance = new HashMap<>();
        for(int key : map.keySet()){
            distance.put(key, Integer.MAX_VALUE);
        }
        distance.put(1,0);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{distance.get(1),1});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int current_distance = current[0], current_node = current[1];
            if(map.containsKey(current_node)){
                for(int[] edge : map.get(current_node)){
                    int neighbor_node = edge[0], weight = edge[1];
                    int neighbor_distance = current_distance + weight;
                    if( neighbor_distance < distance.get(neighbor_node)){
                        distance.put(neighbor_node, neighbor_distance);
                        pq.add(new int[]{neighbor_distance, neighbor_node});
                    }
                }
            }
        }


        int answer = 0;
        for(int key : distance.keySet()){
            if(distance.get(key) <= k){
                answer++;
            }
        }
        return answer;

    }

    public int solution(int N, int[][] road, int K) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int[] val : road){
            int start = val[0], next = val[1], cost = val[2];
            graph.putIfAbsent(start, new ArrayList<>());
            graph.putIfAbsent(next, new ArrayList<>());
            graph.get(start).add(new int[]{next, cost});
            graph.get(next).add(new int[]{start, cost});
        }
        return Dijkstra(graph,K);
    }
}