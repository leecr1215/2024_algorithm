function removeDuplicates(nums: number[]): number {
    const checkArr = [];
    
    let newArr = nums;
    
    for(let i = nums.length; i >= 0; i--){
        if(!checkArr.includes(nums[i])){
            checkArr.push(nums[i]);
        }else{
            // exist checkArr
            newArr.splice(i, 1);
        }
    }
    
    return newArr.length;
};