import java.io.*;
import java.util.*;

public class 연탄의_크기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        int end = 0;

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();

            if(arr[i] > end){
                end = arr[i];
            }
        }

        int max = 0;
        for(int i = 2; i <= end; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(arr[j] % i == 0){
                    cnt++;
                }
            }

            if(cnt > max){
                max = cnt;
            }
        }

        System.out.println(max);
        
    }
}
