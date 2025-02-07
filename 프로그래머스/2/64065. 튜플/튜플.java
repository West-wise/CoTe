import java.util.*;

class Solution {
    public int[] solution(String s) {

        List<List<String>> current = new ArrayList<>();
        String[] split_list = s.split("[{},]");
        List<String> tmp = new ArrayList<>();
        for(String part : split_list) {
            if(part.length() != 0){
                tmp.add(part);
            } else{
                if(!tmp.isEmpty()){
                    current.add(new ArrayList<>(tmp));
                    tmp = new ArrayList<>();
                }
            }
        }
        current.add(new ArrayList<>(tmp));
        current.sort(Comparator.comparingInt(List::size));


        LinkedHashSet<String> set  = new LinkedHashSet<>();
        for(List<String> arr : current){
            set.addAll(arr);
        }

        return set.stream().mapToInt(Integer::valueOf).toArray();
    }
}