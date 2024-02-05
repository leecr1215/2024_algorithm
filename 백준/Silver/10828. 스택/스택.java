import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String calMessage = st.nextToken();

            if(calMessage.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else{
                calculateStack(calMessage);
            }

        }
        System.out.println(sb.toString());
    }

    static void calculateStack(String calMessage){
        switch (calMessage){
            case "pop":
                if(stack.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(stack.pop());
                }
                sb.append("\n");
                break;
            case "size":
                sb.append(stack.size()).append("\n");
                break;
            case "empty":
                if(stack.isEmpty()){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                sb.append("\n");
                break;
            case "top":
                if(stack.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(stack.peek());
                }
                sb.append("\n");
                break;
        }
    }
}