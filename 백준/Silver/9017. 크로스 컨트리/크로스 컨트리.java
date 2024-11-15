import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());

        StringTokenizer st;
        for(int t = 0; t < T; t++){
            int N = stoi(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] teamNum = new int[N];

            int[] cnts = new int[201];
            Arrays.fill(cnts, 0);

            for(int i = 0; i < N; i++){
                teamNum[i] = stoi(st.nextToken());
                cnts[teamNum[i]]++;
            }

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for(int i = 1; i <= 200; i++){
                if(cnts[i] == 6){
                    map.put(i, new ArrayList<Integer>());
                }
            }

            int rank = 1;
            for(int i = 0; i < N; i++){
                if(map.containsKey(teamNum[i])){
                    map.get(teamNum[i]).add(rank++);
                }
            }

            int minScore = Integer.MAX_VALUE;
            int minTeamNum = -1;
            int minFiveScore = -1;

            for(int key : map.keySet()){
                ArrayList<Integer> scores = map.get(key);
                int sum = 0;
                for(int i = 0; i < 4; i++){
                    sum += scores.get(i);
                }

                if(sum < minScore || (sum == minScore && minFiveScore > map.get(key).get(4))){
                    minScore = sum;
                    minTeamNum = key;
                    minFiveScore = map.get(key).get(4);
                }

//                System.out.println(key + " : " + map.get(key).toString());
            }

            System.out.println(minTeamNum);
        }
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}