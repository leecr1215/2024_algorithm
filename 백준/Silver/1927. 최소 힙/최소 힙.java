import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = stoi(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for(int i = 0; i < N; i++){
            int x = stoi(br.readLine());

            if(x == 0){
                if(pq.isEmpty()){
                    bw.write(0 + "\n");
                }else{
                    bw.write(pq.poll() + "\n");
                }
            }else{
                pq.add(x);
            }
        }

        bw.flush();
        bw.close();

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}