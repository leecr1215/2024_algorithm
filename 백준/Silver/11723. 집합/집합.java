import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new HashSet<>();

    static final String ADD = "add";
    static final String REMOVE = "remove";
    static final String TOGGLE = "toggle";
    static final String ALL = "all";
    static final String CHECK = "check";
    static final String EMPTY = "empty";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = stoi(br.readLine());


        for(int t = 0; t < M; t++){
           execute(br.readLine());

        }

        System.out.println(sb);
    }


    public static void execute(String line){
        StringTokenizer st = new StringTokenizer(line);
        String command = st.nextToken();


        if(command.equals(ADD)){
            int x = stoi(st.nextToken());
            set.add(x);
        }else if(command.equals(REMOVE)){
            int x = stoi(st.nextToken());
            if(set.contains(x)){
                set.remove(x);
            }
        }else if(command.equals(CHECK)){
            int x = stoi(st.nextToken());
            if(set.contains(x)){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }

        }else if(command.equals(TOGGLE)){
            int x = stoi(st.nextToken());
            if(set.contains(x)){
                set.remove(x);
            }else{
                set.add(x);
            }
        }else if(command.equals(ALL)){
            set.clear();

            for(int i = 1; i<= 20; i++){
                set.add(i);
            }
        }else if(command.equals(EMPTY)){
            set.clear();
        }
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}