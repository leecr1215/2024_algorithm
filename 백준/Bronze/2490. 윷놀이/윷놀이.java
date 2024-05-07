import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++){
            int zeroCnt = 0;
            int oneCnt = 0;

            for(int j = 0; j < 4; j++){
                int num = sc.nextInt();

                if(num == 0) zeroCnt++;
                else oneCnt++;
            }
            System.out.println(getYut(zeroCnt, oneCnt));

        }
    }

    public static char getYut(int zeroCnt, int oneCnt){
        if(zeroCnt == 1 && oneCnt == 3){
            return 'A';
        }else if(zeroCnt == 2 && oneCnt == 2){
            return 'B';
        }else if(zeroCnt == 3 && oneCnt == 1){
            return 'C';
        }else if(zeroCnt == 4){
            return 'D';
        }else{
            return 'E';
        }
    }
}