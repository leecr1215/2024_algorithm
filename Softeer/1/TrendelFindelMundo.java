import java.util.Scanner;

public class TrendelFindelMundo {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int minX = 1000;
        int minY = 1000;

        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(y <= minY){
                minX = x;
                minY = y;
            }
        }

        System.out.println(minX + " " + minY);
        
    }
}
