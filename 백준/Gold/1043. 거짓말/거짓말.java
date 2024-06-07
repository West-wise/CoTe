import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void BFS(List<List<Integer>> parties, HashSet<Integer> truth){

        ArrayDeque<Integer> queue = new ArrayDeque<>(truth);
        while(!queue.isEmpty()){
            int person = queue.pop();
            for (List<Integer> party : parties){
                if (party.contains(person)) {
                    for(int p : party){
                        if(!truth.contains(p)){
                            queue.add(p);
                            truth.add(p);
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        HashSet<Integer> truth = new HashSet<>();

        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int answer = M;

        String[] truth_person = sc.nextLine().split(" ");
        for (int i=1; i<truth_person.length; i++){
            truth.add(Integer.parseInt(truth_person[i]));
        }


        List<List<Integer>> parties = new ArrayList<>();
        for (int i=0; i<M; i++){
            String[] tmp = sc.nextLine().split(" ");
            List<Integer> party = new ArrayList<>();
            for(int k=1; k<tmp.length; k++){
                party.add(Integer.parseInt(tmp[k]));
            }
            parties.add(party);
        }

        BFS(parties,truth);

        for(List<Integer> party : parties){
            for (Integer person : party){
                if(truth.contains(person)){
                    answer -= 1;
                    break;
                }
            }
        }

        System.out.println(answer);
        sc.close();
    }
}
