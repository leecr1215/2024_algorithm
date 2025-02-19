import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 0; i < N; i++){
            char[] chars = br.readLine().toCharArray();

            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < chars.length; j++){
                if(!stack.isEmpty() && stack.peek() == chars[j]){
                    stack.pop();
                }else{
                    stack.add(chars[j]);
                }
            }

            if(stack.isEmpty()){
               cnt++;
            }
        }

        System.out.println(cnt);

    }
}