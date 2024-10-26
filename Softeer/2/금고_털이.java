import java.io.*;
import java.util.*;

    
public class 금고_털이 {

    public static class Thing {
        int weight; 
        int cost; // 1kg 당 가격

        public Thing(int weight, int cost){
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public String toString(){
            return this.weight + " " + this.cost;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = stoi(st.nextToken());
        int N = stoi(st.nextToken());

        Thing[] things = new Thing[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            Thing thing = new Thing(stoi(st.nextToken()), stoi(st.nextToken()));
            things[i] = thing;
        }
        
        Arrays.sort(things, (t1, t2) -> t2.cost - t1.cost);

        int result = 0;
        for(Thing thing : things){
            if(W == 0) break;

            if(thing.weight >= W){
                // 남은 W를 모두 얘로 채우기
                result += W * thing.cost;
                W -= W;
            }else{
                result += thing.weight * thing.cost;
                W -= thing.weight;
            }
        }
        
        System.out.println(result);
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
