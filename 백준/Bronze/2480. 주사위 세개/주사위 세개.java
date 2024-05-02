import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dice1 = sc.nextInt();
        int dice2 = sc.nextInt();
        int dice3 = sc.nextInt();

        int price = 0;

        if(dice1 == dice2 && dice2 == dice3){
            // 모두 같은 눈
            price = 10000 + dice1 * 1000;
        }else if(dice1 != dice2 && dice2 != dice3 && dice1 != dice3){
            // 모두 다른 눈
            int max = Math.max(Math.max(dice1, dice2), dice3);
            price = max * 100;
        }else{
            // 둘 중에 하나는 같은 눈
            if(dice1 == dice2){
                price = 1000 + dice1 * 100;
            }else if(dice1 == dice3){
                price = 1000 + dice1 * 100;
            }else if(dice2 == dice3){
                price = 1000 + dice2 * 100;
            }
        }

        System.out.println(price);
    }
}