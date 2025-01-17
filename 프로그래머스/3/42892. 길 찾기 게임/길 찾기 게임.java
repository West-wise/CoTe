import java.util.*;
class Node{
    int value;
    int coorX;
    int coorY;
    Node left;
    Node right;

    public Node(int value, int coorX, int coorY) {
        this.value = value; // 몇번째로 입력되었던 좌표인지
        this.coorX = coorX; // x좌표
        this.coorY = coorY; // y좌표
        this.left = null;
        this.right = null;
    }
}
class binaryTree{

    Node root;

    public binaryTree(){
        root = null;
    }

    public void add(int value, int coorX, int coorY){
        root = addNode(root, value,coorX,coorY);
    }

    private Node addNode(Node currentNode, int value, int coorX, int coorY){
        if(currentNode == null) return new Node(value,coorX,coorY);

        if(coorX < currentNode.coorX){
            currentNode.left = addNode(currentNode.left,value,coorX,coorY);
        } else if(coorX > currentNode.coorX){
            currentNode.right = addNode(currentNode.right,value,coorX,coorY);
        }
        return currentNode;
    }

    // 후위 순회
    public void postorder(Node node, List<Integer> answer){
        if(node!=null){
            postorder(node.left,answer);
            postorder(node.right,answer);
            answer.add(node.value);
        }
    }

    // 전위 순회
    public void preorder(Node node, List<Integer> answer){
        if(node != null){
            answer.add(node.value);
            preorder(node.left,answer);
            preorder(node.right,answer);
        }
    }
}
class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int [2][nodeinfo.length];
        Map<List<Integer>,Integer> valMap = new HashMap<>();
        Stack<int[]> nodes = new Stack<>();
        for(int i=1; i<=nodeinfo.length; i++){
            valMap.put(Arrays.asList(nodeinfo[i-1][0],nodeinfo[i-1][1]), i);
            nodes.add(new int[]{nodeinfo[i-1][0],nodeinfo[i-1][1]});
        }
        // 정렬
        nodes.sort((a,b)-> {
           if(b[1] != a[1]){
               return Integer.compare(b[1], a[1]);
           } else{
               return Integer.compare(a[0], b[0]);
           }
        });

        binaryTree tree = new binaryTree();

        for(int[] node : nodes){
            int value = valMap.get(Arrays.asList(node[0],node[1]));
            tree.add(value, node[0], node[1]);
        }
        List<Integer> ans = new ArrayList<>();
        tree.preorder(tree.root,ans);
        answer[0] = ans.stream().mapToInt(i -> i).toArray();
        ans.clear();

        tree.postorder(tree.root, ans);
        answer[1] = ans.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}