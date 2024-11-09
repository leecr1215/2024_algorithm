import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Person{
        int x;
        int y;

        public Person(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        Person[] people = new Person[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());

            people[i] = new Person(x, y);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            Person target = people[i];

            int rank = 1;
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                
                if(target.x < people[j].x && target.y < people[j].y){
                    rank++;
                }
            }
            sb.append(rank + " ");
        }

        System.out.println(sb);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}