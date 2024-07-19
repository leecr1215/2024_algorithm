import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Queue<Integer> queue = new LinkedList<>();
    public static int backValue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            String operator = st.nextToken();

            if(operator.equals("push")){
                push(Integer.parseInt(st.nextToken()));
            }else if(operator.equals("pop")){
                sb.append(pop()).append("\n");
            }else if(operator.equals("size")){
                sb.append(size()).append("\n");
            }else if(operator.equals("empty")){
                sb.append(empty()).append("\n");
            }else if(operator.equals("front")){
                sb.append(front()).append("\n");
            }else{
                sb.append(back()).append("\n");
            }

        }
        System.out.println(sb.toString());


    }

    public static void push(int x){
        queue.add(x);
        backValue = x;
    }

    public static Integer pop(){
        return queue.isEmpty() ? -1 : queue.poll();
    }

    public static Integer size(){
        return queue.size();
    }

    public static Integer empty(){
        return queue.isEmpty() ? 1 : 0;
    }

    public static Integer front(){
        return queue.isEmpty() ? -1 : queue.peek();
    }

    public static Integer back(){
        return queue.isEmpty() ? -1 : backValue;
    }
}