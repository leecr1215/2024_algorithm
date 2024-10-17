// 24.10.17
function solution(numbers, target) {
    let result = 0;
    
    const dfs = (cnt, sum) => {
        if(cnt === numbers.length){
            if(sum === target){
                result++;
            }
            return;
        }
        
        // - 붙이기
        dfs(cnt+1, sum - numbers[cnt]);
        
        // + 붙이기
        dfs(cnt+1, sum + numbers[cnt]);
    }
    
    dfs(0, 0);
    
    return result;
}
