function twoSum(nums: number[], target: number): number[] {
    
    for(let i = 0; i < nums.length; i++){
        const num = target - nums[i];
        const index = nums.indexOf(num);
        
        if(index !== -1 && index !== i){
            // 배열에 있으면서 자기 자신이 아닐 때
            return [i, index];
        }
    }
};