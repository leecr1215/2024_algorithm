import java.io.*;
import java.util.*;

public class 연탄_배달의_시작 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] villages = new int[n];

        for(int i = 0; i < n; i++){
            villages[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        
        for(int i = 0; i < n-1; i++){
            int distance = villages[i+1] - villages[i];

            if(distance == min){
                cnt++;
            }
            else if(distance < min){
                cnt = 1;
                min = distance;
            }
        }

        System.out.println(cnt);
    }
}
