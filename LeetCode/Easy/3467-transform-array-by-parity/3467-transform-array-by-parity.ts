function transformArray(nums: number[]): number[] {
    return nums.map((num) => num % 2 == 0 ? 0 : 1).sort((a, b) => a-b);
};