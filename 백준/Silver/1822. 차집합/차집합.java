import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Integer> A = new TreeSet<>();
        HashSet<Integer> B = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int na = stoi(st.nextToken());
        int nb = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < na; i++){
            A.add(stoi(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nb; i++){
            B.add(stoi(st.nextToken()));
        }

        A.removeAll(B);

        StringBuilder sb = new StringBuilder();
        if(A.size()==0){
            sb.append(0);
        }else{
            sb.append(A.size()).append("\n");

            for(int num : A){
                sb.append(num).append(" ");
            }
        }


        System.out.println(sb);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}