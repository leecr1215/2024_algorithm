import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine());

        StringTokenizer st;
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int testCase = stoi(st.nextToken());
            int result = 0;

            ArrayList<Integer> list = new ArrayList<>();

            for(int i = 0; i < 20; i++){
                int height = stoi(st.nextToken());
                int cnt = 0;

                for(int j = list.size() - 1; j >= 0; j--){
                    int h = list.get(j);
                    if(height < h){
                        cnt++;
                    }else{
                        break;
                    }
                }

                list.add(list.size()-cnt, height);

                result += cnt;
            }

            System.out.println(t + " " + result);

        }
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}