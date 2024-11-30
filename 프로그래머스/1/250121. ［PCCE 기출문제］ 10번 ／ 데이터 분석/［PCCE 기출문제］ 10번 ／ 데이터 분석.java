import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int N = 0;
        int standard1 = standardToIdx(ext);
        for(int i = 0; i < data.length; i++){
            if(data[i][standard1] < val_ext){
                N++;
                
            }
        }
        
        int[][] answer = new int[N][4];
        int idx = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i][standard1] < val_ext){
                answer[idx++] = data[i];
            }
        }
        
        int standard2 = standardToIdx(sort_by);
        
        Arrays.sort(answer, (d1, d2)-> d1[standard2] - d2[standard2]);
        
        return answer;
    }
    
    public static int standardToIdx(String standard){
        int idx = 0;
        if(standard.equals("date")){
            idx = 1;
        }else if(standard.equals("maximum")){
            idx = 2;
        }else if(standard.equals("remain")){
            idx = 3;
        }
        
        return idx;
    }
}