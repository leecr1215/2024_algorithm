import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 0 -> + 기호
// 1 -> - 기호
// 2 -> x 기호
// 3 -> ÷ 기호
public class Main {
    static int[] numbers;
    static int[] picked;
    static LinkedList<Integer> operators; // 연산자 모음
    static boolean[] visited; // 연산자 방문 여부 저장
    static int N; 

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        visited = new boolean[N-1];
        picked = new int[N-1];
        operators = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            int cnt = Integer.parseInt(st.nextToken());

            for(int j = 0; j < cnt; j++){
                operators.push(i);
            }
        }

        permutation(0);

        System.out.println(max);
        System.out.println(min);
    }

    /**
     * 
     * @param cnt : 현재까지 선택한 요소의 개수
     */
    static void permutation(int cnt){
        if(cnt == N-1){
            getMinMaxValue();
            return;
        }

        for(int i = 0; i < N-1; i++){
            if(visited[i]) continue;

            visited[i] = true;
            picked[cnt] = operators.get(i);

            permutation(cnt+1);

            visited[i] = false;
        }

    }

    static void getMinMaxValue(){
        int value = 0;

        for(int i = 0; i < N-1; i++){
            if(i==0){
                value = calculate(numbers[i], numbers[i+1], picked[i]);
            }else{
                value = calculate(value, numbers[i+1], picked[i]);
            }
        }

        if(value < min) min = value;
        if(value > max) max = value;
    }

    static int calculate(int num1, int num2, int operator){
        int result = 0;

        switch (operator){
            case 0:
                result = num1 + num2;
                break;
            case 1:
                result = num1 - num2;
                break;
            case 2:
                result = num1 * num2;
                break;
            case 3:
                result = num1 / num2;
                break;
        }

        return result;
    }

}