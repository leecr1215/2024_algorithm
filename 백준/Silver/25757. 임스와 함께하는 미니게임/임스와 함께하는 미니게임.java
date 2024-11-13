import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<String> player = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String type = st.nextToken();

        for(int i = 0; i < N; i++){
            player.add(br.readLine());
        }

        int result = 0;

        if(type.equals("Y")){
            result = play(2);
        }else if(type.equals("F")){
            result = play(3);
        }else{
            result = play(4);
        }

        System.out.println(result);

    }

    public static int play(int capacity){
        int cnt = player.size() / (capacity - 1);

        return cnt;
    }

}