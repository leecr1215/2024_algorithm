import java.io.*;
import java.util.*;


/**
0단계 4 (행이 2개 각 점 2개)
1단계 9 (행이 3개, 각 점 3개)
2단계 25  (행이 5개, 각 점 5개)
3단계 81 (행이 9개 , 각 점 9개)


**/

public class 지도_자동_구축 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N+1];
        arr[0] = 4;

        int idx = 1;
        int r = 2;
        while(true){
            r = r * 2 - 1;
            arr[idx++] = r*r;

            if(idx > N) break;
        }

        System.out.println(arr[N]);
    }
}
