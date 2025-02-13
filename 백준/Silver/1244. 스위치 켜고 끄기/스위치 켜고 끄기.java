import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] switches;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        switches = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            switches[i] = stoi(st.nextToken());
        }

        int M = stoi(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int gender = stoi(st.nextToken());
            int num = stoi(st.nextToken());

            if(gender == 1){
                men(num);
            }else{
                women(num);
            }
        }

        print();

    }

    public static void men(int num){

        for(int i = num-1; i < N; i+=num){
            switches[i] = switches[i] == 1 ? 0 : 1;
        }
    }

    public static void women(int num){
        // num-1번 스위치는 일단 바꾸기
        switches[num-1] = switches[num-1] == 1 ? 0 : 1;

        int min = Math.min(N-num, num-1);

        for(int i = 1; i <= min; i++){
            if(switches[(num-1)-i] == switches[(num-1)+i]){
                switches[num-1-i] = switches[num-1-i] == 1 ? 0 : 1;
                switches[num-1+i] = switches[num-1+i] == 1 ? 0 : 1;
            }else{
                break;
            }
        }
    }

    public static void print(){
        for(int i = 0; i < N; i++){
            System.out.print(switches[i] + " ");

            if((i+1) % 20 == 0) System.out.println();
        }
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}