function twoSum(nums: number[], target: number): number[] {
    // key : num, value : index
    const map = new Map();
    
    for(let i = 0; i < nums.length; i++){
        const num = target - nums[i];
        
        if(map.get(num)!==undefined){
            return [i, map.get(num)]
        }
        
        map.set(nums[i], i);
    }
};