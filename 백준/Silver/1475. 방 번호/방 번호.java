import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        // 각 개수 저장
        // 6이나 9인 경우 다 6에 저장시키기
        int[] number = new int[10];

        for(int i = 0 ; i < arr.length; i++){
            if(arr[i].equals("6") || arr[i].equals("9")){
                number[6]++;
            }else{
                number[Integer.parseInt(arr[i])]++;
            }
        }

        int maxCnt = 0;

        for(int i = 0; i < number.length; i++){
            if(i == 6){
                maxCnt = Math.max(maxCnt, (number[i] / 2) + (number[i] % 2));
            }else{
                maxCnt = Math.max(maxCnt, number[i]);
            }
        }

        System.out.println(maxCnt);

    }
}