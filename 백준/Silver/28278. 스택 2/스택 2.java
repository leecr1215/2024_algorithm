import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static Stack<Integer> stack = new Stack<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            switch (num) {
                case 1:
                    choose1(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    choose2();
                    break;
                case 3:
                    choose3();
                    break;
                case 4:
                    choose4();
                    break;
                case 5:
                    choose5();
                    break;
            }

        }

        System.out.println(sb.toString());
    }

    public static void choose1(int number){
        // 정수 number를 스택에 넣는다.
        stack.push(number);
    }

    public static void choose2(){
        // 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다.
        // 없다면 -1을 대신 출력한다.
        if(!stack.isEmpty()) {
            sb.append(stack.pop()).append('\n');
        }else{
            sb.append(-1).append('\n');
        }
    }

    public static void choose3(){
        // 스택에 들어있는 정수의 개수를 출력한다.
       sb.append(stack.size()).append('\n');
    }

    public static void choose4(){
        // 스택이 비어있으면 1, 아니면 0을 출력한다.
        if(stack.isEmpty()){
            sb.append(1).append('\n');
        }else{
            sb.append(0).append('\n');
        }
    }

    public static void choose5(){
        // 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
        if(!stack.isEmpty()){
            sb.append(stack.peek()).append('\n');
        }else{
            sb.append(-1).append('\n');
        }
    }
}