import java.io.*;
import java.util.*;

public class 진정한_효도 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int min = Integer.MAX_VALUE;

        
        for(int i = 0; i < 3; i++){
            int rowChange = changeHeight(map[i][0], map[i][1], map[i][2]);
            int colChange = changeHeight(map[0][i], map[1][i], map[2][i]);

            min = Math.min(min, Math.min(rowChange, colChange));
            
        }

        System.out.println(min);
        
    }

   
    public static int changeHeight(int a, int b, int c){
        int min = Integer.MAX_VALUE;
        int[] arr = {a, b, c};

        for(int i = 1; i <=3; i++){

            int diff = 0;

            for(int j = 0; j < 3; j++){
                diff += Math.abs(arr[j] - i);
            }

            if(diff < min){
                min = diff;
            }
        }

        return min;
    }
}
