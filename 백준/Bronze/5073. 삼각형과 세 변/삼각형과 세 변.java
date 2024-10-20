import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());

            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            if(a == 0 && b == 0 && c == 0){
                break;
            }

            String result = validateTriangle(a, b, c);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static String validateTriangle(int a, int b, int c){
        int min = Math.min(Math.min(a, b), c);
        int max = Math.max(Math.max(a, b), c);
        int other = a + b + c - min - max;

        if(max >= min + other){
            return "Invalid";
        }

        if(a == b && b == c){
            return "Equilateral";
        }else if((a == b && b != c) || (a == c && a != b) || (b==c && a != b)){
            return "Isosceles";
        }else{
            return "Scalene";
        }


    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}