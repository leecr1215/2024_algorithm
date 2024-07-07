import java.io.*;
import java.util.*;

public class Main {
    private static int L,C;
    private static char[] arr;
    private static char[] picked;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        picked = new char[L];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < C; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        combination(0, 0);

    }

    public static void combination(int start, int cnt){
        if(cnt == L){
            if(canBePw(picked)){
                for(char num : picked){
                    System.out.print(num);
                }
                System.out.println();
            }
            return;
        }

        for(int i = start; i < C; i++){
            picked[cnt] = arr[i];
            combination(i + 1, cnt + 1);
        }
    }

    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
    public static boolean canBePw(char[] array){
        int vowelCnt = 0;

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < vowels.length; j++){
                if(array[i]==vowels[j]) {
                    vowelCnt++;
                    break;
                }
            }
        }

        if(vowelCnt >= 1 && array.length - vowelCnt >= 2) return true;
        return false;
    }
}