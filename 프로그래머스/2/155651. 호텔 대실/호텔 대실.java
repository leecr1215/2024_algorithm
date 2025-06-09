class Solution {
    public int solution(String[][] book_time) {
        
        final int MINUTE = 24*60+10;
        
        int[] book_cnt = new int[MINUTE];
        
        for(String[] time : book_time){
            int start = toMinute(time[0]);
            int end = toMinute(time[1]) + 10;
            
            for(int i = start; i < end; i++){
                book_cnt[i] += 1;
            }
        }
        
        int max = 0;
        
        for(int cnt : book_cnt){
            if(max < cnt){
                max = cnt;
            }
        }
        
        
        return max;
    }
    
    public static int toMinute(String time){
        String[] t = time.split(":");
        
        int hour = Integer.parseInt(t[0]);
        int minute = Integer.parseInt(t[1]);
        
        return hour * 60 + minute;
    }
}