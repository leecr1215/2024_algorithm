import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        String[] types = new String[N];
        Integer[] powers = new Integer[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            types[i] = st.nextToken();
            powers[i] = stoi(st.nextToken());
        }


        for(int i = 0; i < M; i++){
            int power = stoi(br.readLine());

            // 이분탐색 LOWER BOUND
            int left = 0;
            int right = N;

            while (left < right){
                int mid = (left + right) / 2;

                if(power > powers[mid]){
                    left = mid + 1;
                }else{
                    right = mid;

                }
            }
            

            bw.write(types[left] + "\n");
        }

        bw.flush();
        bw.close();

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}