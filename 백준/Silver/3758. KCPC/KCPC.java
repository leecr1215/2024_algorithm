import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static class Team implements Comparable<Team>{
        int id; // teamid
        int score; // 최종 점수
        int cnt; // 풀이 제출 횟수
        int time; // 마지막 제출 idx


        public Team(int id, int score, int cnt, int time){
            this.id = id;
            this.score = score;
            this.cnt = cnt;
            this.time = time;
        }

        @Override
        public int compareTo(Team o) {
            if(this.score == o.score){
                if(this.cnt == o.cnt){
                    return this.time - o.time;
                }
                else return this.cnt - o.cnt;
            }
            else return o.score - this.score;
        }

        @Override
        public String toString(){
            return this.id + "번 팀 | 점수 : " + this.score + " | 제출횟수 : " + this.cnt + "| 제출 시간 : " + this.time;
        }


    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine());

        StringTokenizer st;
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());

            int n = stoi(st.nextToken()); // 팀 개수
            int k = stoi(st.nextToken()); // 문제 개수
            int teamId = stoi(st.nextToken()); // 팀 ID
            int m = stoi(st.nextToken()); // 로그 개수

            // 각 팀의 최종 제출 시간 저장
            int[] times = new int[n+1];

            // 각 팀의 각 문제에 대해 받은 점수
            int[][] scores = new int[n+1][k+1];

            // 각 팀의 제출 횟수
            int[] cnts = new int[n+1];

            LinkedList<Team> teams = new LinkedList<>();


            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());

                int id = stoi(st.nextToken());
                int problemNum = stoi(st.nextToken());
                int score = stoi(st.nextToken());

                times[id] = i;

                if(scores[id][problemNum] < score){
                    scores[id][problemNum] = score;
                }

                cnts[id]++;

            }

            for(int i = 1; i <= n; i++){
                int score = 0;

                for(int j = 1; j <= k; j++){
                    score += scores[i][j];
                }

                teams.add(new Team(i, score, cnts[i], times[i]));
            }


            Collections.sort(teams);

//            for(Team team : teams){
//                System.out.println(team);
//            }

            int rank = 0;
            for(Team team : teams){
                rank++;

                if(team.id == teamId){
                    break;
                }
            }

            System.out.println(rank);
        }


    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}