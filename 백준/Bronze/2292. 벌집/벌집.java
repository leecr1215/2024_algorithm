import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         * 1 -> 1 (1개)
         * 2 -> 2 ~ 7 (6개)
         * 3 -> 8 ~ 19 (12개)
         * 4 -> 20 ~ 37 (18개)
         * 5 -> 38 ~ 61 (24개)
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int room = 1;

        if(n != 1){
            room = 0;
            int r = 0;
            int temp = 1;

            while(n > 0){
                n -= temp;
                room++;
                r++;
                temp = r * 6;
            }
        }





        System.out.println(room);
    }
}