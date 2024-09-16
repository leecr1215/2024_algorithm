import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String teamName = br.readLine();
            int cnt = Integer.parseInt(br.readLine());

            ArrayList<String> members = new ArrayList<>();

            for(int j = 0; j < cnt; j++){
                String name = br.readLine();

                members.add(name);
            }

            map.put(teamName, members);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String name = br.readLine();
            int category = Integer.parseInt(br.readLine());



            if(category == 0) {
                // 팀 이름으로 멤버 출력
                ArrayList<String> list = map.get(name);

                Collections.sort(list);

                for(String member:list){
                    sb.append(member).append("\n");
                }
            }else {
                // 멤버 이름으로 팀 이름 출력
                Set<String> teams = map.keySet();
                for (String team : teams) {
                    if (map.get(team).contains(name)) {
                        sb.append(team).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.println(sb);

    }
}