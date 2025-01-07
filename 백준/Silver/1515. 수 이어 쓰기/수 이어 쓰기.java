import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * N은 최대?
 * 한자리 수: 9개
 * 두자리 수 : 90개
 * 세자리수 : 900개
 * 네자리 수 :
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        int arrIdx = 0;
        int N = 1;

        while(true){
            String[] str = Integer.toString(N).split("");
            int len = str.length;

            for(int i = 0; i < len; i++){
                if(arrIdx < arr.length && arr[arrIdx].equals(str[i])){
                    arrIdx++;
                }

            }

            if(arrIdx > arr.length - 1){
                break;
            }

            N++;
        }

        System.out.println(N);

    }
}