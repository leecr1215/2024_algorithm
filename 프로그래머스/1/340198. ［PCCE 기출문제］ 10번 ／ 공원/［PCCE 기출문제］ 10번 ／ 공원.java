import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int N = mats.length;
        
        Integer[] newMats = new Integer[N];
        for(int i = 0; i <N; i++){
            newMats[i] = mats[i];
        }
        
        Arrays.sort(newMats, Collections.reverseOrder());
        
        for(int mat : newMats){
            boolean isAble = checkMat(mat, park);
            
            if(isAble){
                return mat;
            }
        }
        
        return -1;
    }
    
    public static boolean checkMat(int matSize, String[][] parks){
        for(int i = 0; i <= parks.length - matSize; i++){
            for(int j = 0; j <= parks[i].length - matSize; j++){
                boolean isAble = true;
                
                for(int k = 0; k < matSize; k++){
                    for(int l = 0; l < matSize; l++){
                        if(!parks[i+k][j+l].equals("-1")){
                            isAble = false;
                            break;
                        }
                    }
                }
                
                if(isAble) return true;
            }
        }
        
        return false;
    }
}