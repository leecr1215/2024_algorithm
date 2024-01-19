import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        recursionFibo(n);
        dynamicFibo(n);

        System.out.println(recursionCnt + " " + dynamicCnt);
    }

    static int recursionCnt;
    public static int recursionFibo(int n){

        if(n == 1 || n == 2){
            recursionCnt++;
            return 1;
        }
        
        return recursionFibo(n-1) + recursionFibo(n-2);
    }

    static int dynamicCnt;
    public static int dynamicFibo(int n){
        int[] fibo = new int[n+1];
        fibo[1] = fibo[2] = 1;

        for(int i = 3; i <= n; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
            dynamicCnt++;
        }

        return fibo[n];
    }
    
}