import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Java 8에서 돌아가게
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int currNum = 665;
        int endNum = 0;

        while(endNum != N){
            currNum += 1;

            if(Integer.toString(currNum).contains("666")){
                endNum++;
            }
        }

        System.out.println(currNum);
    }
}