import java.util.*;
class fileName {
    String head;
    int num;
    String tail;
    String file_name;
    int idx;
    fileName(String file, int idx){
        this.idx = idx;
        this.file_name = file;
        int i = 0;
        while(!Character.isDigit(file.charAt(i))){
            i++;
        }
        this.head = file.substring(0,i);
        int j = i;
        while(j < file.length() && Character.isDigit(file.charAt(j))){
            j++;
        }
        this.num = Integer.parseInt(file.substring(i,j));
        this.tail = file.substring(j);
    }
}
class Solution {
    public String[] solution(String[] files) {
        List<fileName> list = new ArrayList<>();
        for(int i = 0; i<files.length; i++){
            list.add(new fileName(files[i], i));
        }
        list.sort(
                Comparator.comparing((fileName a)->a.head.toLowerCase())
                        .thenComparingInt(a->a.num)
        );
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).file_name;
        }
        return answer;
    }
}