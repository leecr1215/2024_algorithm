function countPairs(nums: number[], target: number): number {
    let result = 0;
    
    let n = nums.length;
    for(let i = 0; i < n-1; i++){
        for(let j = i+1; j < n; j++){
            if(nums[i] + nums[j] < target){
                result++;
            }
        }
    }

    return result;
};