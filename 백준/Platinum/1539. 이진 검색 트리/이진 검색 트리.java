import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[] level = new int[N];

        long sum = 0;

        TreeSet<Integer> tree = new TreeSet<>();

        for(int i = 0; i < N; i++){
            int v = stoi(br.readLine());

            if(tree.higher(v) == null){
                // v보다 큰 값이 없음
                if(tree.lower(v) == null){
                    // v보다 작은 값이 없음
                    level[v] = 1;
                }else{
                    // v보다 작은 값을 가진 객체 중 제일 가까운 값이 있음
                    level[v] = level[tree.lower(v)] + 1;
                }
            }else{
                // v보다 큰 값을 가진 객체가 있음
                if(tree.lower(v) == null){
                    // v보다 작은 값을 가진 객체가 없음
                    level[v] = level[tree.higher(v)] + 1;
                }else{
                    // v보다 작은 값을 가진 객체가 있음
                    level[v] = Math.max(level[tree.higher(v)], level[tree.lower(v)]) + 1;
                }
            }

            sum += level[v];

            tree.add(v);
        }



        System.out.println(sum);
    }


    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}