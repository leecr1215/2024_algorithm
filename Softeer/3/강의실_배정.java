import java.io.*;
import java.util.*;

public class 강의실_배정 {
    public static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = stoi(br.readLine());

        Lecture[] lectures = new Lecture[N];
        
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());

            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, (l1, l2)->{
            if(l1.end == l2.end){
                return l1.start - l2.start;
            }
            return l1.end - l2.end;
        });

        int cnt = 1;
        Lecture curLecture = lectures[0];

        for(int i = 1; i < N; i++){
            if(curLecture.end <= lectures[i].start){
                cnt++;
                curLecture = lectures[i];
            }
        }

        System.out.println(cnt);
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}

