import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int target = stoi(st.nextToken());
        int P = stoi(st.nextToken());

        int[] scores = new int[N];

        if(N != 0){
            st = new StringTokenizer(br.readLine());
        }
        for(int i = 0; i < N; i++){
            scores[i] = stoi(st.nextToken());
        }

        int startRank = 1;
        int endRank = 1;

        for(int i = 0; i < N; i++){
            if(scores[i] > target){
                startRank++;
                endRank++;
            }else if(scores[i] == target){
                endRank++;
            }
        }



        if(endRank <= P){
            System.out.println(startRank);
        }else{
            System.out.println(-1);
        }



    }


    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}