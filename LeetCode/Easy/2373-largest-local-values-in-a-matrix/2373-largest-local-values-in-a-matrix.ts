function largestLocal(grid: number[][]): number[][] {
    const n = grid.length;
    let result = Array.from({length: n-2}, () => new Array(n-2));

    for(let i = 0; i < n-2; i++){
        for(let j = 0; j < n-2; j++){
            let max = 0;
            for(let k = i; k < i+3; k++){
                for(let p = j; p < j+3; p++){
                    if(grid[k][p] > max){
                        max = grid[k][p];
                    }
                }
            }
            result[i][j] = max;
        }
    }

    return result;
};