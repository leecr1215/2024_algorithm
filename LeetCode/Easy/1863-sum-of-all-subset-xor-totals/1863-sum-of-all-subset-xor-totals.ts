function subsetXORSum(nums: number[]): number {
     const len = nums.length;
    const visited = new Array(len).fill(false);
    let result = 0;

     const subset = (cnt: number):void => {
        if(cnt == len){
            let sum = nums.reduce((acc, cur, idx) => visited[idx] ? acc ^ cur : acc, 0);
            result += sum;
            return;
        }

        visited[cnt] = true;
        subset(cnt + 1);

        visited[cnt] = false;
        subset(cnt + 1);
        
     }

    subset(0);
    return result;

};