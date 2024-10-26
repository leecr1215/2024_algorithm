import java.io.*;
import java.util.*;

public class 회의실_예약 {
    public static class Time{
        int start;
        int end;

        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 회의실의 수
        int M = sc.nextInt(); // 예약된 회의 수

        HashMap<String, Boolean[]> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String name = sc.next();
            
            Boolean[] arr = new Boolean[19];
            Arrays.fill(arr, false);
            arr[18] = true;
            
            map.put(name, arr);
        }

        for(int i = 0; i < M; i++){
            String name = sc.next();
            
            int start = sc.nextInt();
            int end = sc.nextInt();

            Boolean[] arr = map.get(name);

            for(int j = start; j < end; j++){
                arr[j] = true;
            }

            map.put(name, arr);
            
        }

      
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for(int i = 0; i < keys.size(); i++){
            ArrayList<Time> result = new ArrayList<>();
            
            String key = keys.get(i);
            System.out.println("Room " + key + ":");

            Boolean[] values = map.get(key);

            int cnt = 0;
            int start = 9;
            int end = 9;
            while(true){
                if(start >= 18 || end >= 18) break;
                
                // start를 false가 나오는 시점으로 이동
                while(true){
                    if(start >= 18 || values[start] == false) break;
                    start++;
                }

                if(start >= 18) break;

                // end를 start 뒤로부터 true가 나오는 시점까지 고
                end = start;
                while(true){
                    if(end >= 18 || values[end] == true) break;
                    end++;
                }
                
                result.add(new Time(start, end));
                cnt++;

                start = end+1;
                end = end+1;
            }
            
            if(cnt == 0){
                System.out.println("Not available");
            }else{
                System.out.println(cnt + " available:");
                for(Time time : result){
                    System.out.printf("%02d-%d\n", time.start, time.end);
                }
            }

            if(i != keys.size()-1){
                System.out.println("-----");
            }
        }

    }
}
