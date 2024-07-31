/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function(rowsCount, colsCount) {
    if(rowsCount * colsCount !== this.length) return [];
    
    const arr = Array.from(new Array(rowsCount), () => new Array(colsCount).fill(0));
    
    // 하, 우, 상, 우
    const dx = [1, 0, -1, 0];
    const dy = [0, 1, 0, 1];
    
    let x = -1;
    let y = 0;
    let d = 0; 
    let idx = 0;
    
    while(idx !== this.length){
        
        let nx = x + dx[d % 4];
        let ny = y + dy[d % 4];
        
        if(nx >= rowsCount || nx < 0 ){
            d++;
        }
        else {
            x = nx;
            y = ny;
            arr[x][y] = this[idx++];
            
            // 방향이 오른쪽일 때는 바로 방향 바꿔주기
            if(d % 4 === 1 || d % 4 === 3){
                d++;
            }
        }
    };
    
    return arr;
    
    
}

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */