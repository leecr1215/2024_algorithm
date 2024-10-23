import java.io.*;
import java.util.*;

public class Recovering_the_Region {
   
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        int[][] board = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = stoi(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(i);

                if(j != N-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
