import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] solutions;
    static int minDiff = 200_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            solutions[i] = stoi(st.nextToken());
        }

        twoPointer();

        System.out.println(minDiff);

    }

    public static void twoPointer(){
        int start = 0;
        int end = N-1;

        while(start < end){
            if(Math.abs(solutions[start] + solutions[end]) < Math.abs(minDiff)){
                minDiff = solutions[start] + solutions[end];
            }

            if(solutions[start] + solutions[end] == 0) break;


            if(solutions[start] + solutions[end] < 0){
                start++;
            }
            else{
                end--;
            }
        }
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}