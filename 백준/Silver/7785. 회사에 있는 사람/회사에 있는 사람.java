import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String, String> map = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
        StringTokenizer st;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state= st.nextToken();

            if(state.equals("leave")){
                map.remove(name);
            }else{
                map.put(name, state);
            }
        }

        for(String name : map.keySet()){
            System.out.println(name);
        }

    }
}