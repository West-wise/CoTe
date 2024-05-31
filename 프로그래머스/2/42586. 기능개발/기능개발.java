import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>() , speed = new ArrayList<>();
        
        for(int i : progresses){
            q.offer(i);
        }
        for(int i : speeds){
            speed.add(i);
        }
        
        while(!q.isEmpty()){
            int cnt = 0;
            for(int i=0; i<q.size(); i++){
                if(q.peek()>=100) q.offer(q.poll());
                else q.offer(q.poll()+speed.get(i));
            }//진도율 더해서 큐에 넣기
            while(!q.isEmpty() && q.peek()>=100){
                cnt++;
                q.poll();
                speed.remove(0);
            }
            if(cnt>0)al.add(cnt);
        }
 
        
        //ArrayList to int[]
        return al.stream().mapToInt(i -> i).toArray();
    }
}