import java.io.*;
import java.util.*;

public class CPTI {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int[] people = new int[N];

        for(int i = 0; i < N; i++){
            people[i] = Integer.parseInt(br.readLine(), 2);
        }

        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){

                int cntOfOne = Integer.bitCount(people[i] ^ people[j]);

                if(cntOfOne <= 2) cnt++;

            }
        }

        System.out.println(cnt);
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
