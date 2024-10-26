import java.io.*;
import java.util.*;

public class X_marks_the_Spot {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            
            String s = st.nextToken().toUpperCase();
            String t = st.nextToken().toUpperCase();

            int idx = s.indexOf("X");
            sb.append(t.charAt(idx));
        }

        System.out.println(sb);
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
