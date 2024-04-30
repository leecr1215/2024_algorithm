import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        int cnt = 0;

        Arrays.sort(arr);

        int pointer1 = 0;
        int pointer2 = n-1;

        while(true){
            if(pointer1 >= pointer2) break;

            if(arr[pointer1] + arr[pointer2] == x) {
                cnt++;
                pointer1++;
                pointer2--;
            }else if(arr[pointer1] + arr[pointer2] < x){
                pointer1++;
            }else{
                pointer2--;
            }
        }

        System.out.println(cnt);
    }
}