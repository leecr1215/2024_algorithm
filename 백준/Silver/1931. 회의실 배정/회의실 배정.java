import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Meeting {
        private int startTime;
        private int endTime;

        Meeting(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "[" + startTime + " " + endTime + "]";
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[N];
        StringTokenizer st = null;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            meetings[i] = new Meeting(startTime, endTime);
        }

        Arrays.sort(meetings, (m1, m2)->{
            if(m1.endTime == m2.endTime){
                return m1.startTime - m2.endTime;
            }
            return m1.endTime - m2.endTime;
        });

        int cnt = 0;
        int curEndTime = 0;
        for(int i = 0; i < N; i++){
            if(curEndTime <= meetings[i].startTime){
                cnt++;
                curEndTime = meetings[i].endTime;
            }
        }

        System.out.println(cnt);
    }
}