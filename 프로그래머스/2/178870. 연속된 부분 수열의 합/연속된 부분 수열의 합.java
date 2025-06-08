class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int sum = sequence[left];
        int minLen = sequence.length+1;
        
        while(right < sequence.length && left <= right){
            if(sum == k){
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    answer[0] = left;
                    answer[1] = right;
                }
                right++;
                
                if(right >= sequence.length) break;
                sum += sequence[right];
            }
            else if(sum < k){
                right++;
                if(right >= sequence.length) break;
                sum += sequence[right];
            }else{
                sum -= sequence[left];
                left++;
            }
        }
        
        return answer;
    }
}