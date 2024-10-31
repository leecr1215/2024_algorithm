import java.io.*;
import java.util.*;

public class 우물_안_개구리 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int[] weights = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            weights[i] = stoi(st.nextToken());
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());

            list.get(A).add(B);
            list.get(B).add(A);
        }

        int result = 0;
        for(int i = 1; i <= N; i++){
            ArrayList<Integer> members = list.get(i);
            int weight = weights[i];
            boolean imBest = true;

            for(int member : members){
                if(weight <= weights[member]){
                    imBest = false;
                    break;
                }
            }

            if(imBest) result++;
        }

        System.out.println(result);
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}

