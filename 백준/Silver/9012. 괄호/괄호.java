import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++){
            char[] parenthesis  = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            boolean isVPS = true;
            for(char c : parenthesis){
                if(c == '('){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()) {
                        isVPS = false;
                        break;
                    }

                    stack.pop();
                }
            }

            if(!stack.isEmpty()) isVPS = false;

            sb.append(boolToString(isVPS)).append("\n");

        }

        System.out.println(sb);

    }

    public static String boolToString(boolean bool){
        return bool ? "YES" : "NO";
    }


}