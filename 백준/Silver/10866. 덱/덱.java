import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            String operate = st.nextToken();

            if(operate.equals("push_front")){
                // 정수 X를 덱의 앞에 넣는다
                push_front(Integer.parseInt(st.nextToken()));
            }else if(operate.equals("push_back")){
                // 정수 X를 덱의 뒤에 넣는다
                push_back(Integer.parseInt(st.nextToken()));
            }else if(operate.equals("pop_front")){
                // 덱의 가장 앞에 있는 수를 빼고 출력
                // 덱에 들어있는 정수가 없는 경우 -1 출력
                pop_front();
            }else if(operate.equals("pop_back")){
                // 덱의 가장 뒤에 있는 수를 빼고 출력
                // 덱에 들어있는 정수가 없는 경우 -1 출력
                pop_back();
            }else if(operate.equals("size")){
                // 덱에 있는 정수 개수 출력
                size();
            }else if(operate.equals("empty")){
                // 덱이 비면 1 아니면 0
                empty();
            }else if(operate.equals("front")){
                // 덱의 가장 앞에 있는 정수 출력
                // 들어있는 정수가 없는 경우 -1 출력
                front();
            }else{
                // 덱의 가장 뒤에 있는 정수 출력
                // 들어있는 정수 없는 경우 -1 출력
                back();
            }

        }
    }

    // 정수 X를 덱의 앞에 넣는다
    public static void push_front(int x){
        deque.addFirst(x);
    }

    // 정수 X를 덱의 뒤에 넣는다
    public static void push_back(int x){
        deque.addLast(x);
    }

    // 덱의 가장 앞에 있는 수를 빼고 출력
    // 덱에 들어있는 정수가 없는 경우 -1 출력
    public static void pop_front(){
        if(deque.isEmpty()){
            System.out.println(-1);
        }else {
            System.out.println(deque.pollFirst());
        }
    }

    // 덱의 가장 뒤에 있는 수를 빼고 출력
    // 덱에 들어있는 정수가 없는 경우 -1 출력
    public static void pop_back(){
        if(deque.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(deque.pollLast());
        }
    }

    // 덱에 있는 정수 개수 출력
    public static void size(){
        System.out.println(deque.size());
    }

    // 덱이 비면 1 아니면 0
    public static void empty(){
        if(deque.isEmpty()){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    // 덱의 가장 앞에 있는 정수 출력
    // 들어있는 정수가 없는 경우 -1 출력
    public static void front(){
        if(deque.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(deque.peekFirst());
        }
    }

    // 덱의 가장 뒤에 있는 정수 출력
    // 들어있는 정수 없는 경우 -1 출력
    public static void back(){
        if(deque.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(deque.peekLast());
        }
    }
}