import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        String[] serials = new String[N];

        for(int i = 0; i < N; i++){
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, (s1, s2) -> {
            if(s1.length() == s2.length()){
                int s1Sum = 0;
                int s2Sum = 0;

                for(int i = 0; i < s1.length(); i++){
                    if(Character.isDigit(s1.charAt(i))) s1Sum += s1.charAt(i) - '0';
                }

                for(int i = 0; i < s2.length(); i++){
                    if(Character.isDigit(s2.charAt(i))) s2Sum += s2.charAt(i) - '0';
                }

                if(s1Sum == s2Sum){
                    return s1.compareTo(s2);
                }

                return s1Sum - s2Sum;
            }

            return s1.length() - s2.length();
        });

        for(String serial : serials){
            System.out.println(serial);
        }

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
