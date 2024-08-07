import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int idx;
        int value;

        public Node(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Node> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            int v = Integer.parseInt(st.nextToken());

            while(true){
                if(stack.isEmpty()){
                    stack.push(new Node(i, v));
                    sb.append("0 ");
                    break;
                }

                Node node = stack.peek();

                if(node.value < v){
                    stack.pop();
                }else{
                    sb.append(node.idx).append(" ");
                    stack.push(new Node(i, v));
                    break;
                }


            }
        }

        System.out.println(sb.toString());


    }
}