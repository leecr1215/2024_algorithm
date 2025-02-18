import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            char[] chars = br.readLine().toCharArray();

            if(chars.length == 1 && chars[0] == '.'){
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isBalance = true;

            for(int i = 0; i < chars.length; i++){
                if(chars[i] == '(' || chars[i] == '['){
                    stack.add(chars[i]);
                }else if(chars[i] == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        isBalance = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }else if(chars[i] == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        isBalance = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }

            if(isBalance && stack.isEmpty()){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }


}