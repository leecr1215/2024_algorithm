import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        Set<String> keywords = new HashSet<>();
        for(int i = 0; i < N; i++){
            keywords.add(br.readLine());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < M; i++){
            String[] strs = br.readLine().split(",");

            for(String str : strs){
                if(keywords.contains(str)){
                    keywords.remove(str);
                }
            }

            bw.write(keywords.size() + "\n");
        }


        bw.flush();
        bw.close();
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}