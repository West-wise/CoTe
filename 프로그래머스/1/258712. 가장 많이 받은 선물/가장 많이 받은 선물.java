import java.util.*;
class Solution {
    static class giftStatus{
        int give;
        int take;
        int status;
        int nextMonth;
        Map<String,Integer> givenTo, takenFrom; //누구에게 줬는지, 누구에게 받았는지
        public giftStatus(int give, int take, String[] friends) {
            this.give = give;
            this.take = take;
            this.givenTo = new HashMap<>();
            this.takenFrom = new HashMap<>();
            this.status = give - take;
            this.nextMonth = 0;
            for(String friend : friends){
                givenTo.put(friend, 0);
                takenFrom.put(friend, 0);
            }
        }

        public void setStatus() {
            this.status = this.give - this.take;
        }
        public void plusGive(String to) {
            this.give += 1;
            this.givenTo.put(to, this.givenTo.getOrDefault(to, 0) + 1);
            this.setStatus();
        }

        public void plusTake(String from) {
            this.take += 1;
            this.takenFrom.put(from, this.takenFrom.getOrDefault(from, 0) + 1);
            this.setStatus();
        }

    }

    public boolean cmpStatus(giftStatus cmp1, giftStatus cmp2) {
        if(cmp1.status > cmp2.status){
            return true;
        } else if (cmp1.status < cmp2.status){
            return false;
        }
        return false;
    }

    public void plusNextMonth(giftStatus cmp1, giftStatus cmp2) {
        if(cmp1.status != cmp2.status){
            if(cmpStatus(cmp1, cmp2)){
                cmp1.nextMonth++;
            } else{
                cmp2.nextMonth++;
            }
        }

    }
    // 비교대상과의 선물지수가 더 크면 tr
    public void comparing(HashMap<String, giftStatus> map, String cmp1, String cmp2) {
        giftStatus cmp1Class = map.get(cmp1);
        giftStatus cmp2Class = map.get(cmp2);
        // 우선 선물을 주고받은 기록이 있는지 확인
        if(cmp1Class.givenTo.get(cmp2)==0 && cmp2Class.givenTo.get(cmp1)==0){
            // 주고받은 적이 없다면 선물지수 확인.
            // 선물지수가 더 큰 사람이 선물지수가 더작은 사람게에 선물을 받는다.
            plusNextMonth(cmp1Class,cmp2Class);
        } else{
            // 선물을 주고받은 적이 있다면 서로 주고받은 갯수를 확인
            if(cmp1Class.givenTo.get(cmp2) > cmp2Class.givenTo.get(cmp1)){
                cmp1Class.nextMonth++;
            } else if (cmp1Class.givenTo.get(cmp2) < cmp2Class.givenTo.get(cmp1)) {
                cmp2Class.nextMonth++;
            } else {
                if (cmp1Class.status != cmp2Class.status){
                    plusNextMonth(cmp1Class,cmp2Class);
                }
            }
        }
    }

    public HashMap<String,giftStatus> initGiftStatus(String[] friends){
        HashMap<String,giftStatus> map = new HashMap<>();
        for (String name : friends){
            map.put(name, new giftStatus(0,0, friends));
        }

        return map;
    }

    public void setStatus(HashMap<String, giftStatus> map, String[] gifts) {

        for (String name : gifts) {
            String[] tmp = name.split(" ");
            String giver = tmp[0];
            String taker = tmp[1];

            map.get(giver).plusGive(taker);
            map.get(taker).plusTake(giver);
        }
    }

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, giftStatus> map = initGiftStatus(friends);
        setStatus(map, gifts);

        // 비교 대상 간 선물 주고받은 정보 비교
        for (int i = 0; i < friends.length; i++) {
            for (int k = i; k < friends.length; k++) {
                if (i!=k){
                    comparing(map, friends[i], friends[k]);
                }
            }
        }

        // nextMonth 값 중 가장 큰 값을 반환
        for (giftStatus tmp : map.values()) {
//            System.out.println(tmp.nextMonth);
            answer = Math.max(answer, tmp.nextMonth);
        }

        return answer;
    }

}