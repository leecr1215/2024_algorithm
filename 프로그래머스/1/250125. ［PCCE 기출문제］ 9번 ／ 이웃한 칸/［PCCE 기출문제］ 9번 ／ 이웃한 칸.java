import java.util.*;

class Solution {
    public static class Node{
        int x;
        int y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int N = board.length;
        
        String color = board[h][w];

        for(int i = 0; i < 4; i++){
            int nx = h + dx[i];
            int ny = w + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny].equals(color)){
                answer++;
            }
        }
        
        
        return answer;
    }
}