import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String word = br.readLine();

            if(word.length() >= M){
                if(map.containsKey(word)){
                    map.put(word, map.get(word) + 1);
                }
                else map.put(word, 1);
            }
        }

        List<String> words = new ArrayList<>(map.keySet());
        words.sort((w1, w2) -> {
            if(map.get(w2) == map.get(w1)){
                if(w1.length() == w2.length()){
                    return w1.compareTo(w2);
                }
                else {
                    return w2.length() - w1.length();
                }
            }else{
                return map.get(w2) - map.get(w1);
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(String word : words){
            bw.write(word + "\n");
        }

        bw.flush();
        bw.close();

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}