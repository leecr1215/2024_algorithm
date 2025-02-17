import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        char value;
        Node left;
        Node right;

        public Node(char value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static class Tree {
        public Node root; // 루트 노드

        public void addNode(char value, char left, char right){
            if(root == null){
                root = new Node(value);
                root.left = left == '.' ? null : new Node(left);
                root.right = right == '.' ? null : new Node(right);
            }else{
                searchNode(root, value, left, right);
            }
        }

        public void searchNode(Node node, char value, char left, char right){
            if(node == null){
                return;
            }
            else if(node.value == value){
                node.left = left == '.' ? null : new Node(left);
                node.right = right == '.' ? null : new Node(right);
            }else{
                searchNode(node.left, value, left, right);
                searchNode(node.right, value, left, right);
            }
        }

        // Root -> Left -> Right
        public void preOrder(Node node){
            if(node != null){
                System.out.print(node.value);
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        // Left -> Root -> Right
        public void inOrder(Node node){
            if(node != null){
                inOrder(node.left);
                System.out.print(node.value);
                inOrder(node.right);
            }
        }

        // Left -> Right -> Root
        public void postOrder(Node node){
            if(node != null){
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.value);
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            tree.addNode(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }

}