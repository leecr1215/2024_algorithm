import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answerLeft = 0;
    static int answerRight = 0;
    static int minSum = 2_000_000_001;

    static int N;
    static int[] solutions;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());

        solutions = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            solutions[i] = stoi(st.nextToken());
        }

        twoPointer();

        System.out.println(answerLeft + " " + answerRight);

    }

    public static void twoPointer(){
        int left = 0;
        int right = N-1;

        while(left < right){
            int sum = solutions[left] + solutions[right];

            if(Math.abs(sum) < minSum){
                minSum = Math.abs(sum);
                answerLeft = solutions[left];
                answerRight = solutions[right];
            }

            if(sum < 0){
                left++;
            }else{
                right--;
            }
        }


    }


    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}